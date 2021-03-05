package com.hubspot.codingchallenge;

import java.util.ArrayList;

public class PartnerCreator {
    public static ArrayList<Partner> getAllPartners() {
        ArrayList<Partner> allPartners = new ArrayList<Partner>();

        ArrayList<String> userAvailabilityDatesOne = new ArrayList<String>();
        userAvailabilityDatesOne.add("2021-02-01");
        userAvailabilityDatesOne.add("2021-02-02");
        userAvailabilityDatesOne.add("2021-02-03");
        userAvailabilityDatesOne.add("2021-02-05");
        Partner partnerOne = new Partner("David", "V", "david@gmail.com", "Norway", userAvailabilityDatesOne);

        ArrayList<String> userAvailabilityDatesTwo = new ArrayList<String>();
        userAvailabilityDatesTwo.add("2021-02-02");
        userAvailabilityDatesTwo.add("2021-02-03");
        userAvailabilityDatesTwo.add("2021-02-06");
        userAvailabilityDatesTwo.add("2021-02-07");
        Partner partnerTwo = new Partner("Frodo", "V", "david@gmail.com", "Norway", userAvailabilityDatesTwo);

        ArrayList<String> userAvailabilityDatesThree = new ArrayList<String>();
        userAvailabilityDatesThree.add("2021-02-11");
        userAvailabilityDatesThree.add("2021-02-12");
        userAvailabilityDatesThree.add("2021-02-13");
        userAvailabilityDatesThree.add("2021-02-15");
        Partner partnerThree = new Partner("Bilbo", "V", "david@gmail.com", "Norway", userAvailabilityDatesThree);

        ArrayList<String> userAvailabilityDatesFour = new ArrayList<String>();
        userAvailabilityDatesFour.add("2021-2-1");
        userAvailabilityDatesFour.add("2021-2-2");
        userAvailabilityDatesFour.add("2021-2-3");
        userAvailabilityDatesFour.add("2021-2-5");
        Partner partnerFour = new Partner("Sam", "V", "david@gmail.com", "Hobbiton", userAvailabilityDatesOne);

        allPartners.add(partnerOne);
        allPartners.add(partnerTwo);
        allPartners.add(partnerThree);
        allPartners.add(partnerFour);

        return allPartners;


    }
}
