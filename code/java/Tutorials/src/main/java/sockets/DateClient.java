package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DateClient {

    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //This establishes connection to the server
        Socket clientSocket = new Socket(hostName, portNumber);

        //Receive the Server Information
        BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String serverResponse = inputFromServer.readLine();

        System.out.println(serverResponse);

        //Close Socket
        clientSocket.close();
        System.out.println("exit");


    }

}


/*
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

 */