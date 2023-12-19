package com.example.demo2;
/**
 * The Person class represents an individual with basic personal information.
 * It is an abstract class providing a common structure for different types of persons.
 */
public abstract class Person {

    // Instance variables to store information about the person
    private String name;            // The name of the person
    private int nationalId;         // The national ID of the person
    private GENDER gender;          // The gender of the person
    private String location;        // The location of the person
    private long phoneNumber;        // The phone number of the person
    private int age;                // The age of the person



    public Person(String name, int nationalId, GENDER gender, String location, int age,long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
        this.gender = gender;
        this.location = location;

        // Validate and set the age of the person
        if (age < 18) {
            throw new IllegalArgumentException("Age must be below or equal to 18");
        } else {
            this.age = age;
        }
    }

    // Getter methods to retrieve information about the person

    public GENDER getGender() {
        return gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getNationalId() {
        return nationalId;
    }

    public GENDER getType() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public int getAge() {
        return age;
    }

    // Additional abstract methods or behavior for subclasses can be added here

}


