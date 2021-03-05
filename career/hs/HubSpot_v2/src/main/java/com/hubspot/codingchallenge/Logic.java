package com.hubspot.codingchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Logic {
    public static void main(String[] args) {
        
        ArrayList<Partner> allPartners = getAllPartners();

        //Unique Country List
        HashSet<String> uniqueCountriesSet = new HashSet<String>();
        //ArrayList<Conference> allPossibleConferences = new ArrayList<Conference>();

        //Country and its Conference
        HashMap<String, Conference> allPossibleConferences = new HashMap<String, Conference>();

        //Loop Over All Partners Names
        for(int i = 0; i < allPartners.size(); i++) {
            String currentCountry = allPartners.get(i).country.toLowerCase();

            //Create a New Conference and Add Dates
            if(!uniqueCountriesSet.contains(currentCountry)) {
                Conference newConference = new Conference(currentCountry);
                allPossibleConferences.put(currentCountry, newConference);
            }
            System.out.println(allPartners.get(i).first_name);
            uniqueCountriesSet.add(currentCountry);

            //Add all these dates and the User to the Right Conference
            Conference currentConference;
            currentConference = allPossibleConferences.get(currentCountry);
            //currentConference.attendeeEmails.add(allPartners.get(i).email);
            //System.out.println(allPossibleConferences.get(currentCountry));
            //System.out.println(currentConference);


            //Loop Over Each Partner and Add the dates they are available to the correct conference
            String currentDate;
            for(int j = 0; j < allPartners.size(); j++) {
                currentDate = allPartners.get(i).datesArray.get(j);
                currentConference.dateList.add(currentDate);
                System.out.println(currentDate);

                //Add Each Date to the Conference Dates Hashmap
                //map.put(millionInts.get(i), map.getOrDefault(millionInts.get(i), 0)+ 1);
                currentConference.allDates.put(currentDate, currentConference.allDates.getOrDefault(currentDate, 0)+ 1);

            }
        }

        //Loop over Output
        String currentKey;
        for (Map.Entry<String, Conference> entry : allPossibleConferences.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            System.out.println("Key = " + entry.getKey());
            currentKey = entry.getKey();


            for(int j = 0; j < allPossibleConferences.get(currentKey).allDates.size(); j++) {
                System.out.println(allPossibleConferences.get(currentKey).allDates.get(j));
            }


        }

        /*
        for(int i = 0; i < allPossibleConferences.size(); i++) {
            System.out.println(allPossibleConferences.get());
            for(int j = 0; j < allPossibleConferences.get(i).allDates.size(); j++) {
                //System.out.println(allPossibleConferences.get(i).allDates.get(j));
            }

        }
        */



        //Add Dates to Hashmap

        /*
                    ArrayList<String> currentPartnerDates = allPartners.get(i).datesArray;
            System.out.println("Partner " + allPartners.get(i).first_name + " " + allPartners.get(i).last_name);
            //Country is Already in the unique Countries Set
            if(uniqueCountriesSet.contains(currentCountry)) {

                //Add each Users Dates to the HashMap
                HashMap<Integer, String> allPossibleDates = new HashMap<Integer, String>();
                for(int j = 0; j < currentPartnerDates.size(); j++) {
                    System.out.println(currentPartnerDates.get(j));
                }


            } else {
                uniqueCountriesSet.add(currentCountry);
            }

         */




    }


    /*
            //Create Array Lists of All Countries
        HashSet<String> allCountries = new HashSet<String>();
        Map<Integer, Integer> mapNorway = new HashMap<Integer, Integer>();

        String searchCountry = "Norway";
        for(int i = 0; i < allUsers.size(); i++) {
            //System.out.println(allUsers.get(i).country);
            allCountries.add(allUsers.get(i).country);
        }

        //Put Dates into Hashmap

        for(int i = 0; i < allUsers.size(); i++) {
            //System.out.println(allUsers.get(i).country);
            allCountries.add(allUsers.get(i).country);
            for(int j = 0; j < allUsers.get(i).datesArray.size(); j++) {
                System.out.println(allUsers.get(i));

            }
            /*
            if(Objects.equals(searchCountry, new String(allUsers.get(i).country))) {

            }
             */


}
