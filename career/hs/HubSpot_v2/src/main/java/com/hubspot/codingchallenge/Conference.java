package com.hubspot.codingchallenge;

import java.util.*;

public class Conference {
    //int attendeeCount;
    ArrayList<String> attendeeEmails;
    ArrayList<String> dateList;
    HashMap<String, Integer> allDates;
    String countryName;
    //String startDate;

    public Conference(String country) {
        this.countryName = country;
        ArrayList<String> dates = new ArrayList<String>();
        this.dateList = dates;

        HashMap<String, Integer> conferences = new HashMap<String, Integer>();
        this.allDates = conferences;
    }

    /*
    @Override
    public String toString(){
        String return1 = attendeeNames.size() + " " + countryName + " " + startDate + " " + attendeeCount;
        return return1;
    }
     */
}
