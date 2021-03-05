package com.hubspot.codingchallenge;

import java.time.LocalDate;
import java.util.*;

public class Conference {
    int attendeeCount;
    ArrayList<String> attendeeEmails;
    HashMap<LocalDate, Integer> allDates;
    String countryName;
    LocalDate startDate;

    public Conference(String country) {
        this.countryName = country;
        HashMap<LocalDate, Integer> allDates = new HashMap<>();
        ArrayList<String> attendeeEmails = new ArrayList<>();
        this.allDates = allDates;
        this.attendeeEmails = attendeeEmails;

    }

    /*
    @Override
    public String toString(){
        String return1 = attendeeNames.size() + " " + countryName + " " + startDate + " " + attendeeCount;
        return return1;
    }
     */
}
