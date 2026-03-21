package com.pitam.lab;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Lab 10: UDP Client-Server - DatagramPacket to send and receive data.
// This example runs both sender and receiver in one program using threads.
public class Lab10_DatagramExample {

    static final int PORT = 9876;

    // UDP Receiver (Server side)
    static class Receiver implements Runnable {
        public void run() {
            try (DatagramSocket socket = new DatagramSocket(PORT)) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                System.out.println("[Receiver] Waiting for data on port " + PORT + "...");
                socket.receive(packet); // blocks until data arrives

                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("[Receiver] Received from "
                        + packet.getAddress() + ":" + packet.getPort()
                        + " -> \"" + received + "\"");
            } catch (Exception e) {
                System.err.println("[Receiver] Error: " + e.getMessage());
            }
        }
    }

    // UDP Sender (Client side)
    static class Sender implements Runnable {
        public void run() {
            try {
                Thread.sleep(500); // small delay to let receiver start first
                DatagramSocket socket = new DatagramSocket();

                String message = "Hello via UDP!";
                byte[] data = message.getBytes();
                InetAddress address = InetAddress.getByName("localhost");

                DatagramPacket packet = new DatagramPacket(data, data.length, address, PORT);
                socket.send(packet);
                System.out.println("[Sender] Sent: \"" + message + "\"");

                socket.close();
            } catch (Exception e) {
                System.err.println("[Sender] Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread receiverThread = new Thread(new Receiver());
        Thread senderThread = new Thread(new Sender());

        receiverThread.start();
        senderThread.start();

        receiverThread.join();
        senderThread.join();
    }
}