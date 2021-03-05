package com.hubspot.codingchallenge;

import java.util.ArrayList;

public class Partner {
    String first_name;
    String last_name;
    String email;
    String country;
    ArrayList<String> datesArray;

    public Partner(String firstName, String lastName, String email, String country, ArrayList<String> dates) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.country = country;
        this.datesArray = dates;
    }



}
