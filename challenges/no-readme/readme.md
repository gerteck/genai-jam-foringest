# No Readme

## Introduction
This application does something. - no idea what. 
It can also be deployed - no idea how.
It might be good if we can monitor it - no idea how either.

## The Challenge
Can you create a readme file for this application? It should be a good readme file as you would expect for any properly maintained application.

## Points
This readme is worth up to 100 points.

## Mark Scheme
100 - The readme makes sense to the instructor and has all the relevant sections that might be expected in production grade readme



---


# README: Compact Disc REST API

A Spring Boot REST API for managing a music CD catalog with full CRUD capabilities.

## Features

- RESTful endpoints for CD operations
- MySQL database integration
- Swagger API documentation
- Log4j2 logging
- Docker support
- Sample frontend examples

## Tech Stack

- Java 11
- Spring Boot 2.5
- Spring Data JPA
- MySQL 8.0
- Swagger UI

## API Endpoints

GET    /api/compactdiscs       - Get all CDs  
GET    /api/compactdiscs/{id}  - Get CD by ID  
POST   /api/compactdiscs       - Add new CD  
DELETE /api/compactdiscs/{id}  - Delete CD  

## Setup

1. Create MySQL database:
   CREATE DATABASE conygre;

2. Import schema from createTables.sql

3. Configure application.properties

4. Run:
   mvn spring-boot:run

Access Swagger docs at:
http://localhost:8080/swagger-ui.html