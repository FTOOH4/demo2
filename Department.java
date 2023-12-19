package com.example.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The Department class represents an academic department within a college.
 * It contains information about the department name, manager, employees, students, courses, and overall score.
 */
public class Department {

    // Instance variables to store information about the department
    private CollegeDepartments department;
    private Employee departmentManager;
    private List<Employee> departmentEmployees;
    private List<Student> departmentStudents;
    private List<Course> departmentCourses;
    private double departmentScore;

    // Constructor to initialize a Department object with the provided information.


    public Department(CollegeDepartments department, List<Employee> departmentEmployees, List<Course> departmentCourses,
                      Employee departmentManager, double departmentScore) {
        this.department = department;
        this.departmentCourses = departmentCourses;
        this.departmentEmployees = departmentEmployees;
        this.departmentScore = departmentScore;

        if (departmentManager.getJobTitle() == JopTitle.PROFFESOR) {             //Check if the department manager has a valid job title
            this.departmentManager = departmentManager;
        } else {
            throw new IllegalStateException("Department manager must be a prof");
        }
    }


    // Getter methods for various attributes of the Department class
    public List<Employee> getDepartmentEmployees() {

        return departmentEmployees;
    }

    public List<Student> getDepartmentStudents() {
        return departmentStudents;
    }

    public CollegeDepartments getDepartment() {
        return department;
    }

    public List<Course> getDepartmentCourses() {
        return departmentCourses;
    }

    public double getDepartmentScore() {
        return departmentScore;
    }

    public String getDepartmentManager() {
        return departmentManager.getName();
    }

}