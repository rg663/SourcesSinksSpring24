package org.example.processes;

import java.io.IOException;

public class Processes {
    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("A", "B").start();
    }
}
