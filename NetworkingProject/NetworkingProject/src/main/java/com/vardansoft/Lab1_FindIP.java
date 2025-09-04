package com.vardansoft;

import java.net.*;

public class Lab1_FindIP {
    public static void main(String[] args) {
        try {
            InetAddress googleAddress = InetAddress.getByName("www.google.com");
            InetAddress myAddress = InetAddress.getLocalHost();
            System.out.println("Google IP Address: " + googleAddress.getHostAddress());
            System.out.println("My IP Address: " + myAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error: " + e);
        }
    }
}