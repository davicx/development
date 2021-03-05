package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //This establishes connection to the server
        Socket clientSocket = new Socket(hostName, portNumber);

        //Keyboard Reader to get input from keyboard
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        //To Send Information to Server (out)
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


        //Receive the Server Information
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        //Ask for Information and send to server
        while(true) {
            System.out.println("Input ");
            String yourInput = keyboard.readLine();
            out.println(yourInput);
            if(yourInput.contains("quit")) {
                break;
            }
            String serverResponse = in.readLine();
            System.out.println(serverResponse);

        }

        //Close Socket
        clientSocket.close();
        System.out.println("exit");
    }
}
