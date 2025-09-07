package com.pitam.lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab1_FindIp {
    public static void main(String[] args) {
        try {
            // Perform DNS resolution to find IP addresses
            System.out.println("=== IP Address Resolution ===");
            // DNS lookup
            InetAddress googleAddress = InetAddress.getByName("www.google.com");
            // Get the local machine's IP address
            InetAddress myAddress = InetAddress.getLocalHost();
            // Print the IP addresses
            System.out.println("Google IP Address: " + googleAddress.getHostAddress());
            System.out.println("My IP Address: " + myAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Network Error: Unable to resolve hostname - " + e.getMessage());
        }
    }
}
