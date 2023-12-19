package com.example.demo2;

/**
 * The Section class represents a specific section of a course.
 * It contains information about the section's teacher, duration, time, and room number.
 */
public class Section {

    // Private fields to store information about the section
    private Employee sectionTeacher;  // The teacher assigned to the section
    private Float duration;           // The duration of the section in hours
    private String sectionTime;       // The time at which the section is scheduled
    private Integer roomNumber;       // The room number where the section takes place

    //Constructor to initialize a Section object with the provided information.

    public Section(Employee sectionTeacher, Float duration, String sectionTime, Integer roomNumber) {
        this.sectionTeacher = sectionTeacher;
        this.duration = duration;
        this.sectionTime = sectionTime;
        this.roomNumber = roomNumber;
    }


    //Getter methods for the private fildes.

    public Employee getSectionTeacher() {
        return sectionTeacher;
    }


    public Float getDuration() {
        return duration;
    }



    public String getSectionTime() {
        return sectionTime;
    }


    public Integer getRoomNumber() {
        return roomNumber;
    }
}