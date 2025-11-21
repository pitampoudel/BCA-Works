package com.pitam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SocketExample {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("google.com", 80);
            OutputStream os = socket.getOutputStream();
            String request = """
                    GET / HTTP/1.1\r
                    Host: google.com\r
                    Connection: close\r
                    """;
            os.write(request.getBytes());
            os.flush();

            //Read response
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
