package com.hubspot.codingchallenge;

import java.util.ArrayList;

//A Class to Handle and Process Raw JSON Data (Used to handle the GSON Data Processing)
public class PartnerModel {
    String first_name;
    String last_name;
    String email;
    String country;
    ArrayList<String> dates;

    public PartnerModel(String firstName, String lastName, String email, String country, ArrayList<String> dates) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.country = country;
        this.dates = dates;
    }

}
