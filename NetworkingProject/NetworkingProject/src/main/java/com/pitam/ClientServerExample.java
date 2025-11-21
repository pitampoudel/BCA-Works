package com.pitam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServerExample {
    static final int port = 5000;

    public static String receiveMessageFromSocket(Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return br.readLine();
    }

    public static void sendMessageToSocket(Socket socket, String text) throws IOException {
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println(text);
    }

    public static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server: listening at " + port);
            while (true) {
                Socket socket1 = serverSocket.accept();
                System.out.println("Message received at server: " + receiveMessageFromSocket(socket1));
                sendMessageToSocket(socket1, "Hello client! Message received");
                socket1.close();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void startClient() {
        try {
            Socket socket = new Socket("localhost", port);
            sendMessageToSocket(socket, "Hello server!");
            System.out.println("Message received at client: " + receiveMessageFromSocket(socket));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}

class ServerExample {
    public static void main(String[] args) {
        ClientServerExample.startServer();
    }
}

class ClientExample {
    public static void main(String[] args) {
        ClientServerExample.startClient();
    }
}