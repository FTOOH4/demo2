package com.example.demo2;

import java.util.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * The Family class represents a group of students with shared activities and trips.
 * It is an abstract class providing a common structure for different types of families.
 */
public abstract class Family {

    // Instance variables to store information about the family
    private static List<HashMap<Family, Trip>> familyTrips = new ArrayList<>();                     // List of trips associated with the family
    private Student familyManager;                                       // The manager of the family
    private String familyName;                                           // The name of the family
    private List<String> familyActivities;                               // List of activities the family engages in
    private List<HashMap<Student, FamilyMemberRole>> familyMembers;     // List of family members and their roles
    private List<HashMap<Family, FamilyEvent>> familyEvents =  new ArrayList<>();  ;

    //Constructor to initialize a Family object with the provided information.

    public Family(Student familyManager, List<String> familyActivities) {
        this.familyManager = familyManager;
        this.familyActivities = familyActivities;
    }

    //Method to enroll family members with their roles.

    public void enrollFamilyMembers(HashMap<Student, FamilyMemberRole>... studentAndRole) {
        familyMembers.addAll(Arrays.asList(studentAndRole));
    }

    /**
     * Getter method to retrieve the manager of the family.

     */


    public Student getFamilyManager() {
        return familyManager;
    }

    //Getter method to retrieve the name of the family.


    //Getter method to retrieve the list of family trips.

    public static List<HashMap<Family, Trip>> getFamilyTrips() {
        return familyTrips;
    }


    public List<HashMap<Family, FamilyEvent>> getFamilyEvents() {
        return familyEvents;
    }

    //Getter method to retrieve the list of family activities.

    public List<String> getFamilyActivities() {
        return familyActivities;
    }

    //Getter method to retrieve the list of family members and their roles.

    public List<HashMap<Student, FamilyMemberRole>> getFamilyMembers() {
        return familyMembers;
    }

    //Abstract method to create a trip for the family.

    public abstract boolean createTrip(Trip trip);
    public abstract boolean createEvent(FamilyEvent event);
}

