package com.sockets;
import java.io.*;
import java.net.*;

public class InteractiveClient {
    public static void main(String[] args) throws IOException {
        //String hostName = "192.168.0.4";
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);

        BufferedReader input = new BufferedReader(new InputStreamReader(echoClientSocket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(echoClientSocket.getOutputStream(), true);

        while(true) {
            System.out.println("Please say something: ");
            String userInput = keyboard.readLine();
            out.println(userInput);

            if(userInput == "quit") {
                break;
            }

            String serverResponse = input.readLine();
            System.out.println("The Server Says " + serverResponse);

        }



    }
}

       /*
        //Create a Keyboard Reader (keyboard)
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(echoClientSocket.getInputStream()));

        //Create what will go to the Server
        PrintWriter outToServerFromClient = new PrintWriter(echoClientSocket.getOutputStream(), true);

        //Create a Loop to Go Over This
        while(true) {
            //Information to get the user input
            System.out.println("Please say something: ");
            String userInputString = userInputReader.readLine();
            System.out.println(userInputString);
            if(userInputString == "quit") {
                break;
            }
            outToServerFromClient.println(userInputString);
        }
        */
        /*
        //Create a Bufferred Reader
        BufferedReader dataReturnedFromServer = new BufferedReader(new InputStreamReader(echoClientSocket.getInputStream()));
        String serverResponse = dataReturnedFromServer.readLine();

        //Display
        System.out.println("Message Starting");
        System.out.println(serverResponse);
        System.out.println("Message Ended");

        //Close socket
        echoClientSocket.close();
        */