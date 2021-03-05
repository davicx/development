package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DateServer {
    public static void main(String[] args) throws IOException {

        int portNumber = 9090;

        ServerSocket listenForClientConnection = new ServerSocket(portNumber);

        //This is the connection it has made
        Socket client = listenForClientConnection.accept();

        //This can send information to the Client
        PrintWriter outFromServerToClient = new PrintWriter(client.getOutputStream(), true);
        outFromServerToClient.println("Hi from the Server ");


        //Make sure to close the socket!
        client.close();
        listenForClientConnection.close();


    }
}


/*


        //Get a Connection from the Server
        //System.out.println("DV: Waiting for a connection");
        Socket client = serverSocket.accept();
        //System.out.println("DV: Connected to client");

        //Create a Buffered Output Sender
        PrintWriter outFromServerToClient = new PrintWriter(client.getOutputStream(), true);

        //Create a Buffered Input Reader
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

* */