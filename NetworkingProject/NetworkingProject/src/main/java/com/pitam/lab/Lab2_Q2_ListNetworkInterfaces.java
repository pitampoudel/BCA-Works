package com.pitam.lab;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

// Lab 2 - Q2: WAP to list all the network interfaces of a local machine.
public class Lab2_Q2_ListNetworkInterfaces {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            System.out.println("=== Network Interfaces ===");
            for (NetworkInterface ni : Collections.list(interfaces)) {
                System.out.println("\nInterface: " + ni.getName() + " (" + ni.getDisplayName() + ")");
                System.out.println("  Up       : " + ni.isUp());
                System.out.println("  Loopback : " + ni.isLoopback());
                System.out.println("  Virtual  : " + ni.isVirtual());

                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                for (InetAddress addr : Collections.list(addresses)) {
                    System.out.println("  Address  : " + addr.getHostAddress());
                }
            }
        } catch (SocketException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}