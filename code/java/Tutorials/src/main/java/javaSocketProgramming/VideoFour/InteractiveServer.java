package javaSocketProgramming.VideoFour;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InteractiveServer {

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


    public static String getRandomName() {
        return "Bilbo Baggins";
    }


}


/*
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
 */
