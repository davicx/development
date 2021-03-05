import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket s;
    DataInputStream din;
    DataOutputStream dout;

    public static void main(String args[])  {
        new Client();
    }

    public Client() {
        System.out.println("DV Client Created");
        try {

            //Socket (Blocks until connect)
            s = new Socket("127.0.0.1", 3333);

            //Get Data in and Out
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            listenForInput();

            //sendInput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    //Listen for input from user and output from Server
    public void listenForInput() {
        System.out.println("DV Listening for Input ");
        Scanner console = new Scanner(System.in);
        while(true) {

            //Sleep so we don't eat up CPU (give processor a break)
            while (!console.hasNextLine()) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            String input = console.nextLine();

            if(input.toLowerCase().equals("quit")){
                break;
            }

            try {

                //Write Data
                dout.writeUTF(input);
                dout.flush();

                //Listen for Data
                while(din.available() == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String reply = din.readUTF();
                    System.out.print("DV Server: " + reply);

                }

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }


        try {
            din.close();
            dout.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


/*

    public void sendInput() throws IOException {

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("Came From David");

    }

* import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Socket s;
    DataInputStream din;
    DataOutputStream dout;

    public static void main(String args[])  {
        new Client();
    }

    public Client() {
        try {

            //Socket (Blocks until connect)
            s = new Socket("127.0.0.1", 3333);

            //Get Data in and Out
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            listenForInput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Listen for input from user and output from Server
    public void listenForInput() {
        Scanner console = new Scanner(System.in);
        while(true) {

            //Sleep so we don't eat up CPU (give processor a break)
            while (!console.hasNextLine()) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            String input = console.nextLine();

            if(input.toLowerCase().equals("quit")){
                break;
            }

            try {

                //Write Data
                dout.writeUTF(input);

                //Listen for Data
                while(din.available() == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String reply = din.readUTF();
                    System.out.print(reply);

                }

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        try {
            din.close();
            dout.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

* */