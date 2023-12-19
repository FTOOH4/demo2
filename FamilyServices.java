package com.example.demo2;

import java.util.Arrays;

/**
 * The FamilyServices class provides services for managing family-related activities such as trip reservations and event creation.
 */
public class FamilyServices {

    //Method to reserve a trip for specified persons.

    public Boolean reserveTrip(Trip trip, Person... persons) {
        return trip.getTripMembers().addAll(Arrays.asList(persons));
    }

    //Method to cancel trip reservations for specified persons.


    public Boolean cancelTripReservation(Trip trip, Person... persons) {
        return trip.getTripMembers().removeAll(Arrays.asList(persons));
    }

    //Method to create a family event.

    public FamilyEvent createEvent(String eventName, String eventLocation,
                                   String eventDescription, int startAt, int endAt, int eventId) {
        return new FamilyEvent(eventName, eventLocation, eventDescription, startAt, endAt, eventId);
    }

    //Method to cancel a family event.

    public Boolean cancelEvent(FamilyEvent familyEvent) {
        return familyEvent.getFamilyEventList().remove(familyEvent);
    }
}

