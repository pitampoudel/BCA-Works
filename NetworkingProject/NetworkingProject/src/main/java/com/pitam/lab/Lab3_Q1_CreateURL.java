package com.pitam.lab;

import java.net.MalformedURLException;
import java.net.URL;

// Lab 3 - Q1: WAP to create a new URL.
public class Lab3_Q1_CreateURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:80/index.html?q=java#section1");

            System.out.println("=== URL Components ===");
            System.out.println("Full URL   : " + url);
            System.out.println("Protocol   : " + url.getProtocol());
            System.out.println("Host       : " + url.getHost());
            System.out.println("Port       : " + url.getPort());
            System.out.println("Path       : " + url.getPath());
            System.out.println("Query      : " + url.getQuery());
            System.out.println("Reference  : " + url.getRef());
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        }
    }
}