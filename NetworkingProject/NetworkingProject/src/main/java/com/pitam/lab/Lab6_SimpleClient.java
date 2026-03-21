package com.pitam.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Lab 6 - Q1: TCP Client-Server Communication (Chat Application) - CLIENT
// Run Lab6_SimpleServer first, then run this
public class Lab6_SimpleClient {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Connecting to server at " + HOST + ":" + PORT + "...");

        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println("Connected! Type messages (type 'bye' to quit).");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                // Send message to server
                System.out.print("Client: ");
                clientMsg = keyboard.readLine();
                out.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    break;
                }

                // Read reply from server
                serverMsg = in.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Server: " + serverMsg);
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server: " + serverMsg);
            }
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}