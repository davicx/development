package javaSocketProgramming.VideoFour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

//This is for Server to Handle Each Client
public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    //Constructor (Socket is Input)
    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while(true) {
                String request = in.readLine();
                System.out.println("SERVER: The Client Sent " + request);
                out.println("SERVER: You said " + request);
            }

        } catch (IOException e) {
            System.err.println("IO Exception in Client Hanlder ");
            System.err.println(e.getStackTrace());
        } finally {

            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
