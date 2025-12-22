package com.pitam;

import java.io.IOException;
import java.net.ServerSocket;

public class PortChecker {
    public static void main(String[] args) {
        for (int i = 0; i <= 65535; i++) {
            try {
                ServerSocket socket = new ServerSocket(i);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage() + " " + i);
            }
        }
    }
}
