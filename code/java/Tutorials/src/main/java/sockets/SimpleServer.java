package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Stop: 11:30 going to make them talk together
public class SimpleServer {

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {

        int portNumber = 9090;

        //listenForClientConnection
        ServerSocket listener = new ServerSocket(portNumber);

        while(true) {

            //This is the connection it has made
            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to client ");
            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);
            pool.execute(clientThread);
        }

    }
}


