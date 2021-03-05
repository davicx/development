import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    ServerSocket ss;
    ArrayList<ServerConnection> connections = new ArrayList<ServerConnection>();
    boolean shouldRun = true;

    public static void main(String args[]) throws IOException, InterruptedException {
        new Server();
        System.out.println("DV Server Created");

    }

    public Server() throws IOException, InterruptedException {
        ss = new ServerSocket(3333);

        while(shouldRun) {

            System.out.println("DV New Connection ");
            Socket s = ss.accept();
            ServerConnection sc = new ServerConnection(s, this);
            sc.start();
            connections.add(sc);

        }

    }
}


//WORKS
/*
* import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket ss;
    Socket s;

    //Open Data input and output streams
    DataInputStream din;
    DataOutputStream dout;

    public static void main(String args[]) throws IOException, InterruptedException {
        new Server();

    }

    public Server() throws IOException, InterruptedException {
        ss = new ServerSocket(3333);

        //Accept Connection (not correct)
        s = ss.accept();
        din = new DataInputStream(s.getInputStream());
        dout = new DataOutputStream(s.getOutputStream());

        listenForData();
    }

    public void listenForData() throws IOException, InterruptedException {
        while (true) {
            while(din.available() == 0) {
                Thread.sleep(1);
            }

            String dataIn = din.readUTF();
            dout.writeUTF(dataIn);
        }
    }


}
*/
