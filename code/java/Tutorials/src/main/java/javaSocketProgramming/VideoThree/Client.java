package javaSocketProgramming.VideoThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        Socket socket = new Socket(hostName, portNumber);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while(true) {
            System.out.println("Input ");
            String yourInput = keyboard.readLine();
            out.println(yourInput);
            if(yourInput.contains("quit")) {
                break;
            }
            String serverResponse = input.readLine();
            System.out.println(serverResponse);

        }

        //Close Socket
        socket.close();
        System.exit(0);
    }
}
