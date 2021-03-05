import java.io.*;
import java.net.Socket;

public class ServerConnection extends Thread {
    Socket socket;
    Server server;
    DataInputStream din;
    DataOutputStream dout;
    boolean shouldRun = true;

    public ServerConnection(Socket socket, Server server) {
        super("ServerConnectionThread");
        this.socket = socket;
        this.server = server;
    }

    public void sendStringToClient(String text) throws IOException {
        text = "DV From Server " + text;
        dout.writeUTF(text);
        dout.flush();
    }

    public void sendStringToAllClients(String text) throws IOException {
        for(int index = 0; index < server.connections.size(); index++) {
            ServerConnection sc = server.connections.get(index);

            sc.sendStringToClient(text);

        }

    }

    public void run() {

        //Open Data Input and Output Streams from Client
        try {
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

            while(shouldRun){
                while(din.available() == 0) {
                    Thread.sleep(1);

                }
                System.out.println("out");

                String textIn = din.readUTF();
                sendStringToAllClients(textIn);
            }
            din.close();
            dout.close();
            socket.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}



