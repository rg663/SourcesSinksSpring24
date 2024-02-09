package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class OutputStreamSample {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            OutputStream outputStream = new FileOutputStream("example.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}