# Find and fix a bug

## Introduction
This project contains a class called ValidateISBN which is used to validate ISBN numbers (the numbers that appear on the barcode on books.).

The class was written using Test driven development techniques, however there is a failing test and the developer cannot work out what is wrong.

## The challenge
* Using GenAI tools, find out what is wrong with the code and fix it.
* You should be able to explain why the code wasn't working and what differences the changes to the code make.
* Be sure to check that every change suggested by the GenAI tool is actually needed.
* In addition, review the code and identify any improvements that could be made. 
* Determine if the descriptions of the exceptions that could be thrown accurate.
* As you make any changes, use the tests to check that the code still works!
* You might also ask the GenAI tools to suggest additional tests that could be added to the test suite.

## Points
This exercise is worth up to 200 points.

## Mark Scheme

* 50 points - fixing the bug!
* 50 points - quality of the fix and appropriateness of the new code
* 50 points - quality of any additional unit tests and appropriate use of exception handling
* 50 points - you can explain to the satisfaction of your instructor what the issue was and why the solution is appropriate


# Bug Explanation 

Bug is present in the ValidateISBN class. The issue is in the calculation of ISBN digits in both isThisAValidShortISBN and isThisAValidLongISBN methods.

The problem is that when getting digits from the ISBN string using charAt(), it's using the ASCII value of the character rather than its numeric value. For example, the character '0' has an ASCII value of 48, '1' is 49, etc.

The test case that was failing was the 13-digit ISBN validation, since it was adding ASCII values directly without any conversion to numeric values. The 10-digit ISBN test with 'X' might have been passing because the 'X' case was handled separately.


