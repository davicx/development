package com.example.helloworld;

import java.io.*;

//LINE READER
public class CopyLines {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("C:/Users/david/Desktop/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("C:/Users/david/Desktop/characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println("line");
                outputStream.println(l);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Please check the file name and path");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
