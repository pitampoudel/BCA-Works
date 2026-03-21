package com.pitam.lab;

import java.net.ServerSocket;

// Lab 7 - Q2: Get a random available port (passing 0 lets the OS assign a free port)
public class Lab7_Q2_RandomPort {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(0)) {
            int randomPort = serverSocket.getLocalPort();
            System.out.println("OS assigned a random available port: " + randomPort);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}