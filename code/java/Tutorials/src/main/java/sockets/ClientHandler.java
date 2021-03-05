package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

//Server
public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;



    //Constructor (takes a client as the input
    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while(true) {
                String messageFromClient = in.readLine();
                out.println("Server Says: " + messageFromClient);
            }

        } catch (IOException e) {
            System.err.println("IO Exception in Client Handler");
            System.err.println(e.getStackTrace());

        } finally {

            //Make sure to close the socket
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
