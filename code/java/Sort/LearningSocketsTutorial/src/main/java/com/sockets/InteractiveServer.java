package com.sockets;
import java.net.*;
import java.io.*;

public class InteractiveServer {
    private static String[] names = {"David", "Bilbo", "Frodo"};
    private static String[] books = {"LOTR", "Narnia", "Redwall"};

    public static void main(String[] args) throws IOException {
        int portNumber = 9090;

        ServerSocket serverSocket = new ServerSocket(portNumber);

        //Get a Connection from the Server
        System.out.println("DV: Waiting for a connection");
        Socket client = serverSocket.accept();
        System.out.println("DV: Connected to client");

        //Create a Buffered Output Sender
        PrintWriter outFromServerToClient = new PrintWriter(client.getOutputStream(), true);

        //Create a Buffered Input Reader
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //Get Data from Client
        try {
            while(true) {
                String clientInputString = inFromClient.readLine();
                outFromServerToClient.println("Hello from the Server~ " + clientInputString);
            }

        } finally {
            //Close the Socket
            System.out.println("DV: Sent date lata!");
            serverSocket.close();
            outFromServerToClient.close();
            inFromClient.close();
            System.exit(0);

        }

    }

    public static String getRandomName() {
        String name = names[(int) (Math.random()* names.length)];
        String book = books[(int) (Math.random()* books.length)];
        return name + " " + book;
    }

}


/*
if(clientInputString.contains("name")) {
    outFromServerToClient.println(getRandomName() + " you said " + clientInputString);
} else {
    outFromServerToClient.println("you didnt say name: " + clientInputString);
}
*/


