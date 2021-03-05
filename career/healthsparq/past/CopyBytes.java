package com.example.helloworld;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//This is a bad example it is using bytes
public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:/Users/david/Desktop/xanadu.txt");
            out = new FileOutputStream("C:/Users/david/Desktop/outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}