package com.pitam.lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Lab 2 - Q1: WAP to check if example.com and example.com.np are the same or not.
public class Lab2_Q1_CompareHosts {
    public static void main(String[] args) {
        try {
            InetAddress address1 = InetAddress.getByName("pitam.com");
            InetAddress address2 = InetAddress.getByName("pitam.com.np");

            System.out.println("pitam.com    -> " + address1.getHostAddress());
            System.out.println("pitam.com.np -> " + address2.getHostAddress());

            if (address1.equals(address2)) {
                System.out.println("Result: Both hosts resolve to the SAME IP address.");
            } else {
                System.out.println("Result: The two hosts resolve to DIFFERENT IP addresses.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Error resolving host: " + e.getMessage());
        }
    }
}