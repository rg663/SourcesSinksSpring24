package org.example;

import java.io.*;

public class WriterSample {
    public static void main(String[] args) {
        try {
            String filePath = "sample.txt";
            Writer writer = new FileWriter(filePath);
            writer.write("Testing");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
