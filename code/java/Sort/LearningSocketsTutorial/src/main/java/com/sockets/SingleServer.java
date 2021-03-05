package com.sockets;
import java.net.*;
import java.io.*;
import java.util.Date;


public class SingleServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 9090;

        ServerSocket serverSocket = new ServerSocket(portNumber);

        System.out.println("DV: Waiting for a connection");
        Socket client = serverSocket.accept();

        System.out.println("DV: Connected to client");
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        String currentDate = new Date().toString();
        currentDate = "DV hi, this came from the server " + currentDate;
        out.println(currentDate);

        //Close the Socket
        System.out.println("DV: Sent date lata!");
        serverSocket.close();
        client.close();

    }
}
