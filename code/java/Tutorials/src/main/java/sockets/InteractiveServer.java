package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class InteractiveServer {

    private static ArrayList<String> allMessages = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        int portNumber = 9090;

        ServerSocket listenForClientConnection = new ServerSocket(portNumber);

        //This is the connection it has made
        Socket client = listenForClientConnection.accept();

        //This can send information to the Client
        PrintWriter outFromServerToClient = new PrintWriter(client.getOutputStream(), true);

        //Get Information from the Client (same on both sides)
        BufferedReader clientInputReader = new BufferedReader(new InputStreamReader(client.getInputStream()));


        //This allows us to close things when were done otherwise we get an unreachable error
        try {
            while(true) {

                //Interactive (One at a time)
                String messageFromClient = clientInputReader.readLine();
                allMessages.add(messageFromClient);
                outFromServerToClient.println("Server Says: " + messageFromClient);

                //Say the whole array
                if (messageFromClient.contains("all")) {
                    printMessages(allMessages);

                }

                //Multiple

            }

        } finally {

            //Make sure to close the socket!
            outFromServerToClient.close();
            clientInputReader.close();

        }

    }

    public static void printMessages(ArrayList<String> allMessages) {
        System.out.println("SERVER: Here are the current messages ");
        for (int i = 0; i < InteractiveServer.allMessages.size(); i++) {
            System.out.print(InteractiveServer.allMessages.get(i) + " ");
        }
    }

}


