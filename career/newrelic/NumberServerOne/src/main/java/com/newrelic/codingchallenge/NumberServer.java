package com.newrelic.codingchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A server that handles incoming numbers or control text from socket connection(s)
 */
public class NumberServer {
    public static final int MAX_CLIENTS = 5;

    private final ExecutorService clientExecutorService = Executors.newFixedThreadPool(MAX_CLIENTS);
    private boolean stopped = false;

    private final Integer port;
    private final String fileName;
    private ServerSocket serverSocket;

    NumberServer(Integer port, String fileName) {
        this.port = port;
        this.fileName = fileName;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(this.port);
        System.out.println("Server Started");
        // Continually accept connections from the ServerSocket
        // The clientExecutorService is a fixedThreadPool which handles keeping only MAX_CLIENTS connections open
        while (!this.stopped) {
            clientExecutorService.execute(socketInputHandler(serverSocket.accept()));
        }
    }

    // Runnable to handle reading input lines from the socket
    public Runnable socketInputHandler(final Socket socket) {
        return () -> {
            try {
                System.out.println("DV: socketInputHandler Called");
                final InputStream inputStream = socket.getInputStream();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    // TODO: Use the input lines instead of just printing them to stdout!
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Lost connection to client");
            }
        };
    }

    // TODO: Call this when terminating this service, and put cleanup tasks here
    private void terminate() throws IOException {
        serverSocket.close();
        this.stopped = true;
        clientExecutorService.shutdownNow();
    }
}
