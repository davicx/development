package com.example.helloworld;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;


public class HelloWorld {
    public static void main(String[] args) throws IOException {

        //PART 1: Input Pets
        Pet snoopy = new Pet(1, "Snoopy", "Dog", "male", 97205);
        Pet willow = new Pet(2, "Willow", "cat", "female", 97205);
        Pet yoda = new Pet(3, "Yoda", "dog", "neutered", 90210);
        Pet lassie = new Pet(4, "Lassie", "dog", "spayed", 90210);
        Pet fluffy = new Pet(5, "fluffy", "rabbit", "female", 97215);
        Pet rhea = new Pet(6, "Rhea", "cat", "spayed", 97215);
        Pet lese = new Pet(7, "Lese", "cat", "spayed", 97215);
        Pet rascal = new Pet(8, "Rascal", "doG", "male", 97205);

        //PART 2: Add Pets into Array
        ArrayList<Pet>  allPetsList = new ArrayList<Pet>();
        allPetsList.add(snoopy);
        allPetsList.add(willow);
        allPetsList.add(yoda);
        allPetsList.add(lassie);
        allPetsList.add(fluffy);
        allPetsList.add(rhea);
        allPetsList.add(lese);
        allPetsList.add(rascal);

        //Filtered Pets List
        //ArrayList<Pet>  filteredPetsList = new ArrayList<Pet>();

        //PART 3: Create Unique Arrays
        //Create an Array of Locations
        ArrayList<String>  arrayOfUniquePetLocations = new ArrayList<String>();

        for (int i = 0; i < allPetsList.size(); i++) {
            //myList.add(yourElement);
            arrayOfUniquePetLocations.add(Integer.toString(allPetsList.get(i).getZipCode()));
        }

        Set<String> tempPetLocations = new HashSet<>();
        tempPetLocations.addAll(arrayOfUniquePetLocations);
        arrayOfUniquePetLocations.clear();
        arrayOfUniquePetLocations.addAll(tempPetLocations);

        //for (int i = 0; i < arrayOfUniquePetLocations.size(); i++) {
            //System.out.println(arrayOfUniquePetLocations.get(i));
        //}

        //Create an Array of Types
        ArrayList<String> arrayOfUniquePetTypes = new ArrayList<String>();

        for (int i = 0; i < allPetsList.size(); i++) {
            arrayOfUniquePetTypes.add(allPetsList.get(i).getType().toLowerCase());
        }

        Set<String> tempPetTypes = new HashSet<>();
        tempPetTypes.addAll(arrayOfUniquePetTypes);
        arrayOfUniquePetTypes.clear();
        arrayOfUniquePetTypes.addAll(tempPetTypes);

        //Create and Array of Genders
        ArrayList<String>  arrayOfUniquePetGenders= new ArrayList<String>();

        for (int i = 0; i < allPetsList.size(); i++) {
            arrayOfUniquePetGenders.add(allPetsList.get(i).getGender().toLowerCase());
        }

        Set<String> tempPetGenders= new HashSet<>();
        tempPetGenders.addAll(arrayOfUniquePetGenders);
        arrayOfUniquePetGenders.clear();
        arrayOfUniquePetGenders.addAll(tempPetGenders);


        //PART 3: User Input
        //Create a Scanner to Accept user Input
        Scanner scan = new Scanner(System.in);

        //System.out.println("Hello, this tool will allow you to search for pets you can adopt. From the command line you can search by Type, Gender, ZipCode or a combination. ");
        //System.out.println("If you want to see a list of searchable options just enter Type, Gender or Zipcode");
        //System.out.println("An example search would be I am looking for a male dog located near 97205");
        //System.out.println("When you are done just type stop");
        System.out.println("Please Enter Your Search: ");

        String userInputString = scan.nextLine();

        String[] userInputArray = userInputString.split("\\s+");
        for (int i = 0; i < userInputArray.length; i++) {
            userInputArray[i] = userInputArray[i].replaceAll("[^\\w]", "").toLowerCase();
        }


        //PART 4: Process User Input
        while (!Arrays.asList(userInputArray).contains("quit")) {
            System.out.println("Please Enter Your Search: ");

            userInputString = scan.nextLine();

            userInputArray = userInputString.split("\\s+");
            for (int i = 0; i < userInputArray.length; i++) {
                userInputArray[i] = userInputArray[i].replaceAll("[^\\w]", "").toLowerCase();
            }


            //PART 5: Handle Search
            //Step 1: User Asked for Generic Help
            if(Arrays.asList(userInputArray).contains("help")) {
                System.out.println("Help");
            }

            //Step 2: User Asked for Help Related to Search Terms
            else if (Arrays.asList(userInputArray).contains("type") || Arrays.asList(userInputArray).contains("gender") || Arrays.asList(userInputArray).contains("zipcode") ) {
                System.out.println("The Searchable values we currently have are the following: ");

                //Type
                System.out.print("Type: ");
                for (int i = 0; i < arrayOfUniquePetTypes.size(); i++) {
                    System.out.print(arrayOfUniquePetTypes.get(i) + " | ");
                }
                System.out.println("");

                //Gender
                System.out.print("Gender: ");
                for (int i = 0; i < arrayOfUniquePetGenders.size(); i++) {
                    System.out.print(arrayOfUniquePetGenders.get(i) + " | ");
                }
                System.out.println("");

                //Location
                System.out.print("Location: ");
                for (int i = 0; i < arrayOfUniquePetLocations.size(); i++) {
                    System.out.print(arrayOfUniquePetLocations.get(i) + " | ");
                }
                System.out.println("");
            }


            //Step 3: User Wants to run a search
            else if (Arrays.asList(userInputArray).contains("search")) {

                //Filtered Pets List
                ArrayList<Pet> filteredPetsList = new ArrayList<Pet>();

                //Filter by Type (you are looking through the user input to see if they entered a search term related to Type
                String searchType = "null";
                for (int i = 0; i < arrayOfUniquePetTypes.size(); i++) {
                    if(Arrays.asList(userInputArray).contains(arrayOfUniquePetTypes.get(i))) {
                        searchType = arrayOfUniquePetTypes.get(i);
                    }
                }

                //Filter by Gender
                String searchGender = "null";
                for (int i = 0; i < arrayOfUniquePetGenders.size(); i++) {
                    if(Arrays.asList(userInputArray).contains(arrayOfUniquePetGenders.get(i))) {
                        searchGender = arrayOfUniquePetGenders.get(i);
                    }
                }

                //Filter by Location
                String searchLocation = "00000";
                for (int i = 0; i < arrayOfUniquePetLocations.size(); i++) {
                    if(Arrays.asList(userInputArray).contains(arrayOfUniquePetLocations.get(i))) {
                        searchLocation = arrayOfUniquePetLocations.get(i);
                    }
                }

                filteredPetsList = searchPetsCombination(allPetsList, searchType, searchGender, searchLocation);
                System.out.println(searchType + " " + searchGender + " " + searchLocation);
                for (int i = 0; i < filteredPetsList.size(); i++) {
                    System.out.println(filteredPetsList.get(i).getName());
                }
            }


            //Step : The User did not enter any search terms
            else {
                System.out.println("Sorry your query didn't contain any search terms, remeber to use the key word 'search'. Also, feel free to type 'help' for instructions");
            }



        }

        {
            System.out.println("Thank you for using our search ");
            scan.close();

        }

    }


    //FUNCTIONS:


    //Function 1: Find Pets by Location
    public static ArrayList<Pet> petsSortedByLocation(ArrayList<Pet> petsSortedByLocation, Integer searchLocation) {


        /*
        for (int i = 0; i < allPetsList.size(); i++) {
            Integer currentLocationToCompare = allPetsList.get(i).getZipCode();

            if (currentLocationToCompare.equals(searchLocation)) {
                petsSortedByLocation.add(allPetsList.get(i));
            }
        }
        */

        return petsSortedByLocation;
    }

    //Function 2: Find Pets by Type
    public static ArrayList<Pet> searchPetsByType(ArrayList<Pet> allPetsList, String searchType) {

        ArrayList<Pet> petsSortedByType = new ArrayList<>();

        for (int i = 0; i < allPetsList.size(); i++) {
            String currentTypeToCompare = allPetsList.get(i).getType();
            currentTypeToCompare = currentTypeToCompare.toLowerCase();
            searchType = searchType.toLowerCase();

            if (Objects.equals(searchType, new String(currentTypeToCompare))) {
                petsSortedByType.add(allPetsList.get(i));
            }
        }

        return petsSortedByType;
    }

    //Function 3: Find Pets by Gender
    public static ArrayList<Pet> searchPetsByGender(ArrayList<Pet> allPetsList, String searchGender) {

        ArrayList<Pet> searchPetsByGenderList = new ArrayList<>();

        for (int i = 0; i < allPetsList.size(); i++) {
            String currentGenderToCompare = allPetsList.get(i).getGender();
            currentGenderToCompare = currentGenderToCompare.toLowerCase();
            searchGender = searchGender.toLowerCase();

            if (Objects.equals(searchGender, new String(currentGenderToCompare))) {
                searchPetsByGenderList.add(allPetsList.get(i));
            }
        }

        return searchPetsByGenderList;
    }

    //Function 4: Find Pets by Combination
    public static ArrayList<Pet> searchPetsCombination(ArrayList<Pet> searchPetsByCombination, String searchType, String searchGender, String searchLocation) {
        searchType = searchType.toLowerCase();
        searchGender = searchGender.toLowerCase();

        //Part 1, Part 2 and Part 3 start with a full list and remove the items that do not match the search criteria

        //PART 1: Filter by Pet Type
        //The first if Statement checks that there is a search type that is not null. If it is null it skips filtering the list of animals because the user wants to see all the animals
        if(!Objects.equals(searchType, new String("null")) ) {

            //If there is a search type it will iterate over the list of animals and remove the ones that don't match (i.e. If you are looking for a dog all the animals that are not dogs will be removed)
            ListIterator<Pet> petListTypeIterator = searchPetsByCombination.listIterator();
            while (petListTypeIterator.hasNext()) {
                if (!petListTypeIterator.next().getType().toLowerCase().equals(searchType)) {
                    petListTypeIterator.remove();
                }
            }
        }

        //PART 2: Filter by Gender
        if(!Objects.equals(searchGender, new String("null")) ) {
            ListIterator<Pet> petListGenderIterator = searchPetsByCombination.listIterator();
            while (petListGenderIterator.hasNext()) {
                if (!petListGenderIterator.next().getGender().toLowerCase().equals(searchGender)) {
                    petListGenderIterator.remove();
                }
            }
        }

        //PART 3: Filter by ZipCode
        if(!Objects.equals(searchLocation, new String("00000"))) {
            ListIterator<Pet> petListLocationIterator = searchPetsByCombination.listIterator();
            while (petListLocationIterator.hasNext()) {
                String currentLocationToCompare = String.valueOf(petListLocationIterator.next().getZipCode());
                if (!currentLocationToCompare.equals(searchLocation)) {
                    petListLocationIterator.remove();
                }
            }
        }


        return searchPetsByCombination;
    }

}


//APPENDIX
        /*
        //Example 1: Search for Pets by Location
        //Integer searchLocation = 97205;
        ArrayList<Pet> locationSortedPetList = petsSortedByLocation(allPetsList, 97215);
        //System.out.println("Sort by Location");

        for (int i = 0; i < locationSortedPetList.size(); i++) {
            //System.out.println(locationSortedPetList.get(i).getName());
        }

        //Example 2: Search for Pets by Type
        ArrayList<Pet> typeSortedPetList = searchPetsByType(allPetsList, "dog");
        //System.out.println("Sort by Name");

        for (int i = 0; i < typeSortedPetList.size(); i++) {
            //System.out.println(typeSortedPetList.get(i).getName());
        }

        //Example 2: Search for Pets by Gender
        ArrayList<Pet> genderSortedPetList = searchPetsByGender(allPetsList, "neutered");
        //System.out.println("Sort by Gender");

        for (int i = 0; i < genderSortedPetList.size(); i++) {
            //System.out.println(genderSortedPetList.get(i).getName());
        }

        //Example 4: Search for Pets by Combination (would most likely pull this with SQL Statements)
        ArrayList<Pet> combinationSortedPetList = searchPetsCombination(allPetsList,"null","male", "00000");

        //searchPetsCombination(filteredPetsList,"null","null", "00000");

        for (int i = 0; i < combinationSortedPetList.size(); i++) {
            //System.out.println(combinationSortedPetList.get(i).getName());
        }
        */
