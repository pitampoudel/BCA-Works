package com.pitam.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

// Lab 5 - Q1: WAP to perform basic socket programming (Read any server data).
// Connects to example.com on port 80 and reads the HTTP response.
public class Lab5_Q1_BasicSocket {
    public static void main(String[] args) {
        String host = "example.com";
        int port = 80;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to: " + host + ":" + port);

            // Send a simple HTTP GET request
            String request = "GET / HTTP/1.1\r\nHost: " + host + "\r\nConnection: close\r\n\r\n";
            socket.getOutputStream().write(request.getBytes());

            // Read the server response
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("=== Server Response ===");
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null && lineCount < 15) {
                System.out.println(line);
                lineCount++;
            }
            System.out.println("======================");
        } catch (Exception e) {
            System.err.println("Socket error: " + e.getMessage());
        }
    }
}