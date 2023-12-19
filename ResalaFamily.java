package com.example.demo2;

import java.util.HashMap;
import java.util.List;

/**
 * The ResalaFamily class represents a specific type of family, ResalaFamily, which extends the Family class.
 * It includes functionality specific to the ResalaFamily, such as creating trips.
 */
public class ResalaFamily extends Family {

    //Constructor to initialize a ResalaFamily with the provided information.

    public ResalaFamily(Student familyManager, List<String> familyActivities) {
        super(familyManager, familyActivities);
    }

    public static String getFamilyName() {
        return "Resala Family";
    }

    //Override method to create a trip specific to the ResalaFamily.

    @Override
    public boolean createTrip(Trip trip) {
        // Create a HashMap to associate the ResalaFamily with the trip
        HashMap<Family, Trip> familyTripHashMap = new HashMap<>();
        familyTripHashMap.put(this, trip);

        // Add the HashMap to the list of family trips
        return getFamilyTrips().add(familyTripHashMap);
    }

    @Override
    public boolean createEvent(FamilyEvent event) {
        HashMap<Family, FamilyEvent> familyEventsHashMap = new HashMap<>();
        familyEventsHashMap.put(this, event);

        // Add the HashMap to the list of family trips
        return getFamilyEvents().add(familyEventsHashMap);

    }
}
