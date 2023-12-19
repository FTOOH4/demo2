package com.example.demo2;

import java.util.List;

/**
 * The Course class represents an academic course offered by a college.
 * It contains information about the course name, associated departments, hours, teacher, score, hour price,
 * assigned section, and a list of assignments related to the course.
 */
public class Course {

    // Instance variables to store information about the course

    private String courseName;
    private int courseHours;
    private Employee courseTeacher;
    private double courseScore;
    private double hourPrice;

    private Section section;
    private List<Assignments> courseAssignments;


    // Constructor to initialize a Course object with the provided information.

    public Course(String courseName, int courseHours, Employee courseTeacher, double courseScore, double hourPrice) {
        this.courseName = courseName;
        this.courseHours = courseHours;
        if (courseTeacher.getJobTitle() == JopTitle.PROFFESOR || courseTeacher.getJobTitle() == JopTitle.TEACHING_ASSISTANT) {
            this.courseTeacher = courseTeacher;
        } else {
            throw new IllegalArgumentException("Teacher must be either doctor or assistant");
        }
        this.courseScore = courseScore;
        this.hourPrice = hourPrice;
    }

    //// Check if the teacher has a valid job title.
    public List<Assignments> getCourseAssignments() {
        return courseAssignments;
    }


    //Method to remove the course from a specified department.

    // Getter and setter methods for various attributes of the Course class

    public void setCourseAssignments(Assignments courseAssignment) {
        courseAssignments.add(courseAssignment);
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Section getSection() {
        return section;
    }


    public String getCourseName() {
        return courseName;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public Employee getCourseTeacher() {
        return courseTeacher;
    }

    public double getCourseScore() {
        return courseScore;
    }

    public double getHourPrice() {
        return hourPrice;
    }
}
