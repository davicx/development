package javaSocketProgramming.VideoThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int portNumber = 9090;

        //Wait for Client Connection
        System.out.println("Waiting for Connection");
        ServerSocket listener = new ServerSocket(portNumber);
        Socket client = listener.accept();
        System.out.println("Server Connected");

        //This can send information to the Client
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        try {
            while(true) {
                String request = in.readLine();
                System.out.println("SERVER: The Client Sent " + request);
                out.println("SERVER: You said " + request);
            }

        } finally {
            out.close();
            in.close();
        }
    }


    public static String getRandomName() {
        return "Bilbo Baggins";
    }


}
