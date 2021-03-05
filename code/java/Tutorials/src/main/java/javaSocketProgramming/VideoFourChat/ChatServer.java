package javaSocketProgramming.VideoFourChat;

import javaSocketProgramming.VideoFour.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        int portNumber = 9090;
        ServerSocket listener = new ServerSocket(portNumber);

        //Wait for Client Connection
        while(true) {

            System.out.println("Waiting for Connection");
            Socket client = listener.accept();
            System.out.println("Server Connected");

            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);
            pool.execute(clientThread);

        }
    }
}


