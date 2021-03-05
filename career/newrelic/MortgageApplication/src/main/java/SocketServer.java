import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    int portNumber = 4000;
    String hostName = "127.0.0.1";
    ServerSocket serverSocket = null;

    //Create Method to Run Server Associated with our Port Number
    public void runServer() throws IOException {
        serverSocket = new ServerSocket(portNumber);

        //Create a new connection and store
        while(true) {

            //Each time we accept a new connection we create a client Socket
            Socket clientSocket = serverSocket.accept();
            MortgageRunnable m = new MortgageRunnable(clientSocket);
            new Thread(m).start();

            //Create New Thread Here

        }


    }




}
