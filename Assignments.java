package com.example.demo2;

import java.util.List;

/**
 * The Assignments class represents an assignment in an educational context.
 * It contains information about the assignment name, description, grade, number of students,
 * deadline, bonus status, and a list of students who have submitted the assignment.
 */
public class Assignments {

    // Private fields to store information about the assignment
    private String assignmentName;           // The name of the assignment
    private String assignmentDescription;    // The description of the assignment
    private Float grade;                     // The grade assigned to the assignment
    private Integer numberOfStudents;        // The total number of students assigned the assignment
    private String assignmentDeadline;       // The deadline for submitting the assignment
    private Boolean isBonus;                 // Indicates whether the assignment is a bonus assignment
    private List<Student> submittedStudents;  // List of students who have submitted the assignment


    // Constructor to initialize an Assignments object with the provided information.


    public Assignments(String assignmentName, String assignmentDescription, Float grade,
                       Integer numberOfStudents, String assignmentDeadline, Boolean isBonus) {
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.grade = grade;
        this.numberOfStudents = numberOfStudents;
        this.assignmentDeadline = assignmentDeadline;
        this.isBonus = isBonus;
    }


    //Method to mark an assignment as delivered by a student.

    public Boolean deliverAssignment(Student student) {
        return submittedStudents.add(student);
    }



// Getter method to retrieve the list of students who have submitted the assignment

    public List<Student> getSubmittedStudents() {
        return submittedStudents;
    }

    // Getter methods for other fields

    // ...
}

