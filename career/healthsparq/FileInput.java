package com.example.helloworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class FileInput {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "C:/Users/David/Desktop/pets.csv";
        File petDataFile = new File(inputFileName);
        //Scanner scanner = new Scanner(new File(inputFileName));

        ArrayList<Pet> allPetsList = new ArrayList<Pet>();
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
        allPetsList.add(snoopy);
        allPetsList.add(willow);
        allPetsList.add(yoda);
        allPetsList.add(lassie);
        allPetsList.add(fluffy);
        allPetsList.add(rhea);
        allPetsList.add(lese);
        allPetsList.add(rascal);
*/
        try {
            int petDataFileCount = 1;

            Scanner inputStream = new Scanner(petDataFile);
            while(inputStream.hasNext()) {
                String data = inputStream.next();
                String[] values = data.split(",");

                if (petDataFileCount != 1) {


                    int thisPetID = Integer.parseInt(values[0]);
                    String thisPetName = values[1];
                    String thisPetType = values[2];
                    String thisPetGender = values[3];
                    int thisPetZipCode = Integer.parseInt(values[4]);

                    allPetsList.add(new Pet(thisPetID,thisPetName, thisPetType, thisPetGender, thisPetZipCode));
                    //Pet thisPetName= new Pet(8, "Rascal", "doG", "male", 97205);
                }


                petDataFileCount = petDataFileCount + 1;
            }
            inputStream.close();

            for (int i = 0; i < allPetsList.size(); i++) {
                System.out.println(allPetsList.get(i).getName());
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}