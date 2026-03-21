package com.pitam.lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Lab 1 - Q2: WAP to fetch the IP address of a website.
public class Lab1_Q2_WebsiteIP {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Host Name : " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}