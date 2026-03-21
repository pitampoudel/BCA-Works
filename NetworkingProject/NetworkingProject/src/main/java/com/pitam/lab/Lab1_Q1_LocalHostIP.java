package com.pitam.lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Lab 1 - Q1: WAP to fetch the IP address of a local host.
public class Lab1_Q1_LocalHostIP {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Host Name : " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}