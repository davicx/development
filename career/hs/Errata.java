package com.hubspot.codingchallenge;

public class Errata {


        /*
        Conference currentConference = new Conference("Norway");

        //Loop Over All Partners Names
        for(int i = 0; i < allPartners.size(); i++) {
            String currentDate;
            for (int j = 0; j < allPartners.size(); j++) {
                currentDate = allPartners.get(i).datesArray.get(j);
                currentConference.dateList.add(currentDate);

                //Add Each Date to the Conference Dates Hashmap
                currentConference.allDates.put(currentDate, currentConference.allDates.getOrDefault(currentDate, 0) + 1);
            }
        }

        allPossibleConferences.put("Norway", currentConference);
        String currentKey;
        for (Map.Entry<String, Conference> entry : allPossibleConferences.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            System.out.println("Key = " + entry.getKey());
            currentKey = entry.getKey();

            for(int j = 0; j < allPossibleConferences.get(currentKey).allDates.size(); j++) {
                System.out.println(allPossibleConferences.get(currentKey).allDates.get(j));
            }


        }

         */


            /*
            String currentCountry = allPartners.get(i).country.toLowerCase();
            uniqueCountriesSet.add(currentCountry);
            //Create a New Conference and Add Dates
            if(!uniqueCountriesSet.contains(currentCountry)) {
                Conference newConference = new Conference(currentCountry);
                allPossibleConferences.put(currentCountry, newConference);
            }
            System.out.println(allPossibleConferences.size());
            */
            /*
            uniqueCountriesSet.add(currentCountry);

            //Add all these dates and the User to the Right Conference
            Conference currentConference;
            currentConference = allPossibleConferences.get(currentCountry);
            //currentConference.attendeeEmails.add(allPartners.get(i).email);
            //System.out.println(allPossibleConferences.get(currentCountry));
            //System.out.println(currentConference);

            //Loop Over Each Partner and Add the dates they are available to the correct conference


             */
      /*
        //Loop over all the Partners and get their available dates and the country they are from
        for(int i = 0; i < allPartners.size(); i++) {
            System.out.println(allPartners.get(i).firstName + " " + allPartners.get(i).lastName + " " + allPartners.get(i).country);

            //Loop Over each Date the Current Partners is Available
            for (int j = 0; j < allPartners.get(i).datesArray.size()-1; j++) {
                currentDate = LocalDate.parse(allPartners.get(i).datesArray.get(j));
                nextAvailableDate = LocalDate.parse(allPartners.get(i).datesArray.get(j+1));
                currentDateTomorrow = currentDate.plusDays(1);

                //Check if they are available two days in a row and add the date to a map
                if(currentDateTomorrow.compareTo(nextAvailableDate) == 0) {
                    //System.out.println("Two days in a row! " + currentDate + " " + nextAvailableDate);

                    //NEXT! Track Max Here
                    datesMap.put(currentDate, datesMap.getOrDefault(currentDate, 0)+ 1);
                    //System.out.println(datesMap.get(currentDate));
                    //maxProfit = Math.max(maxProfit, prices[i]-cheapestPrice);
                }

            }
        }

        //OUTPUT: Loop Over Date Map
        for (Map.Entry<LocalDate, Integer> entry : datesMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        */

        /*

            //Loop Over each Date the Current Partners is Available
            for (int j = 0; j < allPartners.get(i).datesArray.size()-1; j++) {
                currentDate = LocalDate.parse(allPartners.get(i).datesArray.get(j));
                nextAvailableDate = LocalDate.parse(allPartners.get(i).datesArray.get(j+1));
                currentDateTomorrow = currentDate.plusDays(1);

                //Check if they are available two days in a row and add the date to a map
                if(currentDateTomorrow.compareTo(nextAvailableDate) == 0) {
                    //System.out.println("Two days in a row! " + currentDate + " " + nextAvailableDate);

                    //NEXT! Track Max Here
                    datesMap.put(currentDate, datesMap.getOrDefault(currentDate, 0)+ 1);
                    //System.out.println(datesMap.get(currentDate));
                    //maxProfit = Math.max(maxProfit, prices[i]-cheapestPrice);
                }
            }
        }
        */



}
