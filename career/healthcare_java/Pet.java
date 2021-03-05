package com.example.helloworld;

public class Pet {
    private int petId;
    private String name;
    private String type;
    private String gender;
    private int zipCode;

    //Construct a New Pet
    public Pet(int createPetId, String createName, String createType, String createGender, int createZipCode) {
        petId = createPetId;
        name = createName;
        type = createType;
        gender = createGender;
        zipCode = createZipCode;

    }

    //Get Pet Information
    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public int getZipCode() {
        return zipCode;
    }

}
