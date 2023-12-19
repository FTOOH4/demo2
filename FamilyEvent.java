package com.example.demo2;

import java.util.List;

import java.util.List;

/**
 * The FamilyEvent class represents an event associated with a family, such as a gathering or activity.
 * It includes information about the event name, description, location, start and end times, unique ID, and the family it belongs to.
 */
public class FamilyEvent {

    // Instance variables to store information about the family event
    private List<FamilyEvent> familyEventList;  // List of family events
    private String eventName;                   // The name of the family event
    private String description;                 // The description of the family event
    private String location;                    // The location of the family event
    private int startAt;                         // The start time of the family event
    private int endAt;                           // The end time of the family event
    private int id;                              // The unique ID of the family event

    //Constructor to initialize a FamilyEvent object with the provided information.

    public FamilyEvent(String eventName, String description, String location, int startAt, int endAt, int id) {
        this.eventName = eventName;
        this.description = description;
        this.location = location;
        this.startAt = startAt;
        this.endAt = endAt;
        this.id = id;
    }

    //Getter method to retrieve the unique ID of the family event.


    public int getEventId() {
        return id;
    }

    //Getter method to retrieve the list of family events.

    public List<FamilyEvent> getFamilyEventList() {
        return familyEventList;
    }


}
