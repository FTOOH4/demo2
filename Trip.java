package com.example.demo2;

import java.util.List;

/**
 * The Trip class represents an organized trip with details such as location, title, description, date, price, and members.
 */
public class Trip {

    // Instance variables to store information about the trip
    private String location;         // The location of the trip
    private String title;            // The title of the trip
    private String description;      // The description of the trip
    private String date;             // The date of the trip
    private double price;            // The price of the trip
    private Boolean isDone = false;  // The completion status of the trip
    private List<Person> tripMembers; // List of persons participating in the trip

    //Constructor to initialize a Trip object with the provided information.

    public Trip(String location, String title, String description, String date, double price) {
        this.location = location;
        this.title = title;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    //Getter method to retrieve the list of trip members.

    public List<Person> getTripMembers() {
        return tripMembers;
    }

    //Getter method to check if the trip is marked as done.


    public Boolean isDone() {
        return isDone;
    }

    /**
     * Setter method to mark the trip as done.
     */
    public void setIsDoneToTrue() {
        isDone = true;
    }

    // Getter methods to retrieve information about the trip

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
