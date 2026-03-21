package com.pitam.lab;

import java.net.ServerSocket;

// Lab 7 - Q1: Look for local open ports (LocalPortScanner)
public class Lab7_Q1_LocalPortScanner {
    public static void main(String[] args) {
        int startPort = 1;
        int endPort = 1024;

        System.out.println("Scanning local ports from " + startPort + " to " + endPort + "...");
        System.out.println("Ports in use (not available):");

        for (int port = startPort; port <= endPort; port++) {
            try (ServerSocket ss = new ServerSocket(port)) {
                // Port is available — do nothing
            } catch (Exception e) {
                // Port is already in use
                System.out.println("  Port " + port + " is IN USE");
            }
        }

        System.out.println("Scan complete.");
    }
}