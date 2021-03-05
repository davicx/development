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

        for (int j = 0; j < userInputArray.length; j++) {
            //System.out.println(userInputArray[j]);
        }

        //PART 4: Process User Input




        //Step 1: User Asked for Generic Help
        if(Arrays.asList(userInputArray).contains("quit")) {
            System.out.println("Quit");

        }

        //Step 1: User Asked for Generic Help
        else if(Arrays.asList(userInputArray).contains("help")) {
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


        //Step 5: The User did not enter any search terms
        else {

        }
        

        //once finished
        scan.close();

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
  /*
        Scanner scanner = new Scanner(System.in);

        System.out.print( "Enter the filename: " );
        String fileName = scanner.nextLine();
        File petDataFile = new File( fileName );

        if (petDataFile.exists()) {
            Scanner inFile = new Scanner(petDataFile);
            //Scanner scanner = new Scanner(new File("C:/Users/David/Desktop/pets.csv"));
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
                System.out.print(scanner.next()+"|");
            }
            scanner.close();
            // For each line in the file, read in the line and display it with the line number
            int lineNum = 0;

            // Use the results of calling the hasNext method to
            // determine if you are at the end of the file before
            // reading the next line of the file.
            while ( inFile.hasNext() )
            {
                String line = inFile.nextLine();   // read the next line

                // Output the line read to the screen for the user
                System.out.println( ++lineNum + ": " + line );
            }

            // When we're done reading the file,
            // close the Scanner object attached to the file
          //   inFile.close();

        /*
        } else {
            System.out.println("Sorry the File did not load properly, please feel free to try again or load the example data (pets.txt) in the doc folder");
            System.out.println("You can also reach out to me.");
            System.out.println("Vasquezd@oregonstate.edu");
            System.out.println("(925) 818-1172");
        }



        Scanner scanner = new Scanner(new File("C:/Users/David/Desktop/pets.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
         */

    }
}


/*
  System.out.print( "Enter the filename: " );   // Prompt the user for a file name
    String fileName = scanner.nextLine();         // get a file name from the user
    File file = new File( fileName );             // create a File object

    if ( file.exists() )                          // check that the file exists
    {                                             // before trying to create a
                                                  // Scanner to read the file
        // Create a Scanner from the file.
        // This statement can cause a FileNotFoundException.
        Scanner inFile = new Scanner( file );

        // For each line in the file, read in the line and display it with the line number
        int lineNum = 0;

        // Use the results of calling the hasNext method to
        // determine if you are at the end of the file before
        // reading the next line of the file.
        while ( inFile.hasNext() )
        {
            line = inFile.nextLine();   // read the next line

            // Output the line read to the screen for the user
            System.out.println( ++lineNum + ": " + line );
        }

        // When we're done reading the file,
        // close the Scanner object attached to the file
        inFile.close();
    }
*/

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


package com.example.helloworld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;


public class HelloWorld {
    public static void main(String[] args) throws IOException {


        //Step 1: Input Pets
        Pet snoopy = new Pet(1, "Snoopy", "Dog", "male", 97205);
        Pet willow = new Pet(2, "Willow", "cat", "female", 97205);
        Pet yoda = new Pet(3, "Yoda", "dog", "neutered", 90210);
        Pet lassie = new Pet(4, "Lassie", "dog", "spayed", 90210);
        Pet fluffy = new Pet(5, "fluffy", "rabbit", "female", 97215);
        Pet rhea = new Pet(6, "Rhea", "cat", "spayed", 97215);
        Pet lese = new Pet(7, "Lese", "cat", "spayed", 97215);
        Pet rascal = new Pet(8, "Rascal", "doG", "male", 97205);

        //Step 2: Add Pets into Array
        ArrayList<Pet>  allPetsList = new ArrayList<Pet>();
        allPetsList.add(snoopy);
        allPetsList.add(willow);
        allPetsList.add(yoda);
        allPetsList.add(lassie);
        allPetsList.add(fluffy);
        allPetsList.add(rhea);
        allPetsList.add(lese);
        allPetsList.add(rascal);

        //allPetsList
        ArrayList<Pet>  filteredPetsList = new ArrayList<Pet>();
        String searchType = "rabbit";
        searchType = searchType.toLowerCase();
        String searchGender = "female";
        searchGender = searchGender.toLowerCase();
        String searchLocation = "97215";

        //INTRO: Create List to Filter
        for (int i = 0; i < allPetsList.size(); i++) {
            //System.out.println(allPetsList.get(i));
            filteredPetsList.add(allPetsList.get(i));
            //petsSortedByType.add(allPetsList.get(i));
        }

        //Part 1, Part 2 and Part 3 start with a full list and remove the items that do not match the search criteria

        //PART 1: Filter by Pet Type
        //The first if Statement checks that there is a search type that is not null. If it is null it skips filtering the list of animals because the user wants to see all the animals
        if(!Objects.equals(searchType, new String("null")) ) {

            //If there is a search type it will iterate over the list of animals and remove the ones that don't match (i.e. If you are looking for a dog all the animals that are not dogs will be removed)
            ListIterator<Pet> petListTypeIterator = filteredPetsList.listIterator();
            while (petListTypeIterator.hasNext()) {
                if (!petListTypeIterator.next().getType().toLowerCase().equals(searchType)) {
                    petListTypeIterator.remove();
                }
            }
        }

        //PART 2: Filter by Gender
        if(!Objects.equals(searchGender, new String("null")) ) {
            ListIterator<Pet> petListGenderIterator = filteredPetsList.listIterator();
            while (petListGenderIterator.hasNext()) {
                if (!petListGenderIterator.next().getGender().toLowerCase().equals(searchGender)) {
                    petListGenderIterator.remove();
                }
            }
        }

        //PART 3: Filter by ZipCode
        if(!Objects.equals(searchLocation, new String("00000"))) {
            ListIterator<Pet> petListLocationIterator = filteredPetsList.listIterator();
            while (petListLocationIterator.hasNext()) {
                String currentLocationToCompare = String.valueOf(petListLocationIterator.next().getZipCode());
                if (!currentLocationToCompare.equals(searchLocation)) {
                    petListLocationIterator.remove();
                }
            }
        }


        //PART 4: Output the Value
        for (int i = 0; i < filteredPetsList.size(); i++) {
            System.out.println(filteredPetsList.get(i).getName());
        }



        //Step 3: Search for Pets by Location
        //Integer searchLocation = 97205;
        ArrayList<Pet> locationSortedPetList = petsSortedByLocation(allPetsList, 97215);
        //System.out.println("Sort by Location");

        for (int i = 0; i < locationSortedPetList.size(); i++) {
            //System.out.println(locationSortedPetList.get(i).getName());
        }

        //Step 4: Search for Pets by Type
        ArrayList<Pet> typeSortedPetList = searchPetsByType(allPetsList, "dog");
        //System.out.println("Sort by Name");

        for (int i = 0; i < typeSortedPetList.size(); i++) {
            //System.out.println(typeSortedPetList.get(i).getName());
        }

        //Step 5: Search for Pets by Gender
        ArrayList<Pet> genderSortedPetList = searchPetsByGender(allPetsList, "neutered");
        //System.out.println("Sort by Gender");

        for (int i = 0; i < genderSortedPetList.size(); i++) {
            //System.out.println(genderSortedPetList.get(i).getName());
        }

        //Step 6: Search for Pets by Combination (would most likely pull this with SQL Statements)


    }

    //Function 1: Find Pets by Location
    public static ArrayList<Pet> petsSortedByLocation(ArrayList<Pet> allPetsList, Integer searchLocation) {

        ArrayList<Pet> petsSortedByLocation = new ArrayList<>();

        for (int i = 0; i < allPetsList.size(); i++) {
            Integer currentLocationToCompare = allPetsList.get(i).getZipCode();

            if (currentLocationToCompare.equals(searchLocation)) {
                petsSortedByLocation.add(allPetsList.get(i));
            }
        }

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

        ArrayList<Pet> searchPetsByGender = new ArrayList<>();

        for (int i = 0; i < allPetsList.size(); i++) {
            String currentGenderToCompare = allPetsList.get(i).getGender();
            currentGenderToCompare = currentGenderToCompare.toLowerCase();
            searchGender = searchGender.toLowerCase();

            if (Objects.equals(searchGender, new String(currentGenderToCompare))) {
                searchPetsByGender.add(allPetsList.get(i));
            }
        }

        return searchPetsByGender;
    }

    //Function 4: Find Pets by Combination

}



/////////////

package com.example.helloworld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;


public class HelloWorld {
    public static void main(String[] args) throws IOException {


        //SEARCH
        /*
        int number = 123;
        String numberAsString = String.format ("%05d", number);
        System.out.println(numberAsString)
        */
        //Step 1: Input Pets
        Pet snoopy = new Pet(1, "Snoopy", "Dog", "male", 97205);
        Pet willow = new Pet(2, "Willow", "cat", "female", 97205);
        Pet yoda = new Pet(3, "Yoda", "dog", "neutered", 90210);
        Pet lassie = new Pet(4, "Lassie", "dog", "spayed", 90210);
        Pet fluffy = new Pet(5, "fluffy", "rabbit", "female", 97215);
        Pet rhea = new Pet(6, "Rhea", "cat", "spayed", 97215);
        Pet lese = new Pet(7, "Lese", "cat", "spayed", 97215);
        Pet rascal = new Pet(8, "Rascal", "doG", "male", 97205);

        //Step 2: Add Pets into Array
        ArrayList<Pet>  allPetsList = new ArrayList<Pet>();
        allPetsList.add(snoopy);
        allPetsList.add(willow);
        allPetsList.add(yoda);
        allPetsList.add(lassie);
        allPetsList.add(fluffy);
        allPetsList.add(rhea);
        allPetsList.add(lese);
        allPetsList.add(rascal);

        //allPetsList
        ArrayList<Pet>  filteredPetsList = new ArrayList<Pet>();
        String searchType = "rabbit";
        searchType = searchType.toLowerCase();
        String searchGender = "female";
        searchGender = searchGender.toLowerCase();
        String searchLocation = "97215";

        //INTRO: Create List to Filter
        for (int i = 0; i < allPetsList.size(); i++) {
            //System.out.println(allPetsList.get(i));
            filteredPetsList.add(allPetsList.get(i));
            //petsSortedByType.add(allPetsList.get(i));
        }

        //Part 1, Part 2 and Part 3 start with a full list and remove the items that do not match the search criteria

        //PART 1: Filter by Pet Type
        //The first if Statement checks that there is a search type that is not null. If it is null it skips filtering the list of animals because the user wants to see all the animals
        if(!Objects.equals(searchType, new String("null")) ) {

            //If there is a search type it will iterate over the list of animals and remove the ones that don't match (i.e. If you are looking for a dog all the animals that are not dogs will be removed)
            ListIterator<Pet> petListTypeIterator = filteredPetsList.listIterator();
            while (petListTypeIterator.hasNext()) {
                if (!petListTypeIterator.next().getType().toLowerCase().equals(searchType)) {
                    petListTypeIterator.remove();
                }
            }
        }

        //PART 2: Filter by Gender
        if(!Objects.equals(searchGender, new String("null")) ) {
            ListIterator<Pet> petListGenderIterator = filteredPetsList.listIterator();
            while (petListGenderIterator.hasNext()) {
                if (!petListGenderIterator.next().getGender().toLowerCase().equals(searchGender)) {
                    petListGenderIterator.remove();
                }
            }
        }

        //PART 3: Filter by ZipCode
        if(!Objects.equals(searchLocation, new String("00000"))) {
            ListIterator<Pet> petListLocationIterator = filteredPetsList.listIterator();
            while (petListLocationIterator.hasNext()) {
                String currentLocationToCompare = String.valueOf(petListLocationIterator.next().getZipCode());
                if (!currentLocationToCompare.equals(searchLocation)) {
                    petListLocationIterator.remove();
                }
            }
        }


        //PART 4: Output the Value
        for (int i = 0; i < filteredPetsList.size(); i++) {
            System.out.println(filteredPetsList.get(i).getName());
        }






        //Step 3: Search for Pets by Location
        //Integer searchLocation = 97205;
        ArrayList<Pet> locationSortedPetList = petsSortedByLocation(allPetsList, 97215);
        //System.out.println("Sort by Location");

        for (int i = 0; i < locationSortedPetList.size(); i++) {
            //System.out.println(locationSortedPetList.get(i).getName());
        }

        //Step 4: Search for Pets by Type
        ArrayList<Pet> typeSortedPetList = searchPetsByType(allPetsList, "dog");
        //System.out.println("Sort by Name");

        for (int i = 0; i < typeSortedPetList.size(); i++) {
            //System.out.println(typeSortedPetList.get(i).getName());
        }

        //Step 5: Search for Pets by Gender
        ArrayList<Pet> genderSortedPetList = searchPetsByGender(allPetsList, "neutered");
        //System.out.println("Sort by Gender");

        for (int i = 0; i < genderSortedPetList.size(); i++) {
            //System.out.println(genderSortedPetList.get(i).getName());
        }

        //Step 6: Search for Pets by Combination (would most likely pull this with SQL Statements)


    }

    //Function 1: Find Pets by Location
    public static ArrayList<Pet> petsSortedByLocation(ArrayList<Pet> allPetsList, Integer searchLocation) {

        ArrayList<Pet> petsSortedByLocation = new ArrayList<>();

        for (int i = 0; i < allPetsList.size(); i++) {
            Integer currentLocationToCompare = allPetsList.get(i).getZipCode();

            if (currentLocationToCompare.equals(searchLocation)) {
                petsSortedByLocation.add(allPetsList.get(i));
            }
        }

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

        ArrayList<Pet> searchPetsByGender = new ArrayList<>();

        for (int i = 0; i < allPetsList.size(); i++) {
            String currentGenderToCompare = allPetsList.get(i).getGender();
            currentGenderToCompare = currentGenderToCompare.toLowerCase();
            searchGender = searchGender.toLowerCase();

            if (Objects.equals(searchGender, new String(currentGenderToCompare))) {
                searchPetsByGender.add(allPetsList.get(i));
            }
        }

        return searchPetsByGender;
    }

    //Function 4: Find Pets by Combination

}


