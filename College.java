package com.example.demo2;

/**
 * The College class represents a college in the context of an educational institution.
 * It contains information about the college name, location, grade, dean, and fees for each year.
 */
public class College {

    // Constants representing attributes of the college
    public static final String NAME = "FACULTY OF ELECTRONIC ENGINEERING";
    public static final String LOCATION = "Menouf / Menofia / Egypt";
    public static final double COLLEGE_GRADE = 85.0;
    public static final String COLLEGE_DEAN = "AYMAN ELSAYED";
    public static final double FIRST_YEAR_FEES = 1000.0;
    public static final double SECOND_YEAR_FEES = 1200.0;
    public static final double THIRD_YEAR_FEES = 1000.0;
    public static double Cs_Department_Grade = 75.0;
    public static double Control_Department_Grade = 65.0;
    public static double Communication_Department_Grade = 60.0;

    // Instance variable to store services offered by the college
    private final CollegeServices services;

    // Constructor to initialize a College object with the provided services.

    public College(CollegeServices services) {
        this.services = services;
    }

    // Getter method to retrieve the services offered by the college.


    public CollegeServices getServices() {
        return services;
    }
}

