package com.example.demo2;


 /* The RegisterAtDepartment class is responsible for handling the logic related to student registration
        * for different departments based on their grades. It follows the Single Responsibility Principle,
        * focusing on a single responsibility of determining whether a student is allowed to register in a specific department.
        */
public class RegisterAtDepartment {

    //Checks if a student with a given grade is allowed to register in a specific department.


    public Boolean isStudentAllowed(double studentGrade, CollegeDepartments department) {
        // Using a switch statement to handle different department-specific grade requirements
        switch (department) {
            case COMPUTER_SCIENCE -> {
                return studentGrade >= College.Cs_Department_Grade;
            }
            case CONTROL -> {
                return studentGrade >= College.Control_Department_Grade;
            }
            case COMMUNICATION -> {
                return studentGrade >= College.Communication_Department_Grade;
            }
            default -> {
                // If the department is not recognized, the student is not allowed to register
                return false;
            }
        }
    }
}

