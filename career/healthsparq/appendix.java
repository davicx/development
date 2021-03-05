package com.example.helloworld;

import java.util.ArrayList;

public class Appendix {
	
	
        //////////////////////
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
    /*
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
    ArrayList<Pet> allPetsList = new ArrayList<Pet>();
        allPetsList.add(snoopy);
        allPetsList.add(willow);
        allPetsList.add(yoda);
        allPetsList.add(lassie);
        allPetsList.add(fluffy);
        allPetsList.add(rhea);
        allPetsList.add(lese);
        allPetsList.add(rascal);

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


     */
}
