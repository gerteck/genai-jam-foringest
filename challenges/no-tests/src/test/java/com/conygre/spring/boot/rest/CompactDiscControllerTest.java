// src/test/java/com/conygre/spring/boot/rest/CompactDiscControllerTest.java
package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.entities.CompactDisc;
import com.conygre.spring.boot.services.CompactDiscService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompactDiscControllerTest {

    @Mock
    private CompactDiscService service;

    @InjectMocks
    private CompactDiscController controller;

    private CompactDisc disc1;
    private CompactDisc disc2;

    @BeforeEach
    void setUp() {
        // For older Mockito versions, use initMocks instead of openMocks
        MockitoAnnotations.initMocks(this);
        
        disc1 = new CompactDisc("Album 1", 10.99, "Artist 1", 10);
        disc1.setId(1);
        disc2 = new CompactDisc("Album 2", 12.99, "Artist 2", 12);
        disc2.setId(2);
    }

    @Test
    void findAllShouldReturnAllDiscs() {
        // Arrange
        List<CompactDisc> discs = Arrays.asList(disc1, disc2);
        when(service.getCatalog()).thenReturn(discs);

        // Act
        Iterable<CompactDisc> result = controller.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, ((List<CompactDisc>) result).size());
        verify(service, times(1)).getCatalog();
    }

    @Test
    void getCdByIdShouldReturnDiscWhenExists() {
        // Arrange
        when(service.getCompactDiscById(1)).thenReturn(disc1);

        // Act
        CompactDisc result = controller.getCdById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Album 1", result.getTitle());
        verify(service, times(1)).getCompactDiscById(1);
    }

    @Test
    void getByIdWith404ShouldReturnNotFoundWhenDiscDoesNotExist() {
        // Arrange
        when(service.getCompactDiscById(99)).thenReturn(null);

        // Act
        ResponseEntity<CompactDisc> response = controller.getByIdWith404(99);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(service, times(1)).getCompactDiscById(99);
    }

    @Test
    void deleteCdByIdShouldCallService() {
        // Act
        controller.deleteCd(1);

        // Assert
        verify(service, times(1)).deleteCompactDisc(1);
    }

    @Test
    void addCdShouldCallService() {
        // Arrange
        CompactDisc newDisc = new CompactDisc("New Album", 9.99, "New Artist", 8);

        // Act
        controller.addCd(newDisc);

        // Assert
        verify(service, times(1)).addNewCompactDisc(newDisc);
    }
}