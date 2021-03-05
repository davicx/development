package com.hubspot.codingchallenge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Map<LocalDate, Integer> datesMap = new HashMap<LocalDate, Integer>();

    public static void main(String[] args) throws ParseException {
        ArrayList<Partner> allPartners = PartnerCreator.getAllPartners();

        //WORKS
        //LocalDate plusDays(long daysToAdd)
        LocalDate currentDate;
        LocalDate nextAvailableDate;
        LocalDate currentDateTomorrow;

        //Loop Over all the Partners
        for(int i = 0; i < allPartners.size(); i++) {
           //System.out.println(allPartners.get(i).first_name + " " + allPartners.get(i).last_name + " " + allPartners.get(i).country);

            //Loop Over each Date the Current Partners is Available
            for (int j = 0; j < allPartners.get(i).datesArray.size()-1; j++) {
                currentDate = LocalDate.parse(allPartners.get(i).datesArray.get(j));
                nextAvailableDate = LocalDate.parse(allPartners.get(i).datesArray.get(j+1));
                currentDateTomorrow = currentDate.plusDays(1);
                //System.out.println(currentDate + " " + currentDateTomorrow);

                //Check if they are available two days in a row and add the date to a map
                if(currentDateTomorrow.compareTo(nextAvailableDate) == 0) {
                    //System.out.println("Two days in a row! " + currentDate + " " + nextAvailableDate);

                    //NEXT! Track Max Here
                    datesMap.put(currentDate, datesMap.getOrDefault(currentDate, 0)+ 1);
                    System.out.println(datesMap.get(currentDate));
                    //maxProfit = Math.max(maxProfit, prices[i]-cheapestPrice);
                }
            }
            //System.out.println();
        }

        //Loop Over Date Map
        for (Map.Entry<LocalDate, Integer> entry : datesMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }


    }

    public static Date addDays(Date date, int daysToAdd) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();

        return date;

    }


}

