package com.pitam.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Lab 6 - Q1: TCP Client-Server Communication (Chat Application) - SERVER
// Run this first, then run Lab6_SimpleClient
public class Lab6_SimpleServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Server started. Waiting for client on port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                // Read from client
                clientMsg = in.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Client: " + clientMsg);
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + clientMsg);

                // Send reply
                System.out.print("Server: ");
                serverMsg = keyboard.readLine();
                out.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            clientSocket.close();
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}