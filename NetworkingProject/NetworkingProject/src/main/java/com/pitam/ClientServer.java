package com.pitam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ServerSocketExample {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Client connected");
                System.out.println(br.readLine());
            }
        }
    }

}


class ClientSocketExample {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 1234)) {
            OutputStream stream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(stream, true);
            writer.println("Hello World");
        }
    }
}