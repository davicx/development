package com.sockets;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class DateClient {
    public static void main(String[] args) throws IOException {
        //String hostName = "192.168.0.4";
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);

        //Create a Bufferred Reader
        BufferedReader dataReturnedFromServer = new BufferedReader(new InputStreamReader(echoClientSocket.getInputStream()));
        String serverResponse = dataReturnedFromServer.readLine();

        //Display
        System.out.println("Message Starting");
        System.out.println(serverResponse);
        System.out.println("Message Ended");

        //Close socket
        echoClientSocket.close();

    }
}