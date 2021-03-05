package com.example.helloworld;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) throws IOException {

        //INPUT
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a String: ");
        //int n = reader.nextInt(); // Scans the next token of the input as an int.
        String inputString = scan.next();
        if(!Objects.equals(inputString, new String("hello"))) {
            System.out.println("please enter hllo");
        } else {
            System.out.println(inputString);
        }
        //once finished

        reader.close();
    }
}
