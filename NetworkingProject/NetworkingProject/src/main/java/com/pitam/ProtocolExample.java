package com.pitam;

import java.net.URI;

public class ProtocolExample {
    public static void main(String[] args) {
        testProtocol("http://www.google.com");
        testProtocol("ftp://ftp.google.com");
        testProtocol("https://www.google.com");
        testProtocol("mailto:pitam@gmail.com");
        testProtocol("tel:1234567890");
        testProtocol("file:///C:/Users/Pitam/Desktop/test.txt");
        testProtocol("telnet://www.google.com");
        testProtocol("news://news.google.com");
        testProtocol("gopher://gopher.google.com");
        testProtocol("jdbc:mysql://localhost:3306/test");
        testProtocol("ldap://localhost:389");

    }

    private static void testProtocol(String url) {
        System.out.println("URL: " + url);
        try {
            URI uri = new URI(url);
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println();

    }
}
