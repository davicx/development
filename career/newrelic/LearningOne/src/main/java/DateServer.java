import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DateServer {

    public static void main(String args[]) throws IOException {
        ServerSocket listener = new ServerSocket(4000);

        //Only allows one client
        Socket client = listener.accept();


    }
}
