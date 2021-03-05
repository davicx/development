package com.sockets;
import java.net.*;
import java.io.*;
import java.util.Date;


public class NameServer {
    private static String[] names = {"David", "Bilbo", "Frodo"};
    private static String[] books = {"LOTR", "Narnia", "Redwall"};

    public static void main(String[] args) throws IOException {
        int portNumber = 9090;

        ServerSocket serverSocket = new ServerSocket(portNumber);

        System.out.println("DV: Waiting for a connection");
        Socket client = serverSocket.accept();

        System.out.println("DV: Connected to client");
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println(getRandomName());

        //Close the Socket
        System.out.println("DV: Sent date lata!");
        serverSocket.close();
        client.close();
        System.exit(0);

    }

    public static String getRandomName() {
        String name = names[(int) (Math.random()* names.length)];
        String book = books[(int) (Math.random()* books.length)];
        return name + " " + book;
    }

}
