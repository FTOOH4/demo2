package com.example.demo2;

import java.util.HashMap;
import java.util.List;

/**
 * The FeeLifeMakers class represents a specific type of family, FeeLifeMakers, which extends the Family class.
 * It includes functionality specific to the FeeLifeMakers family, such as creating trips.
 */
public class FeeLifeMakers extends Family {

    //Constructor to initialize a FeeLifeMakers family with the provided information.

    public FeeLifeMakers(Student familyManager, List<String> familyActivities) {
        super(familyManager, familyActivities);
    }
    public static String getFamilyName() {
        return "Fee Life Makers";
    }
    //Override method to create a trip specific to the FeeLifeMakers family.

    @Override
    public boolean createTrip(Trip trip) {
        // Create a HashMap to associate the FeeLifeMakers family with the trip
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
