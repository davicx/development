package com.hubspot.codingchallenge;

import java.util.ArrayList;

//A Class to Handle and Process Raw JSON Data (Used to handle the GSON Data Processing)
public class Partner {
    String firstName;
    String lastName;
    String email;
    String country;
    ArrayList<String> datesArray;

    public Partner(String firstName, String lastName, String email, String country, ArrayList<String> dates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.datesArray = dates;
    }



}
