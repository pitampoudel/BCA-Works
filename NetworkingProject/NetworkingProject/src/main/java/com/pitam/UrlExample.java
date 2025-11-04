package com.pitam;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlExample {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("https://www.google.com:80/docs/resource1.html?query=123#fragment");
        System.out.println("URI: " + uri);
        System.out.println("Scheme: " + uri.getScheme());
        System.out.println("Host: " + uri.getHost());
        System.out.println("Port: " + uri.getPort());
        System.out.println("Path: " + uri.getPath());
        System.out.println("Query: " + uri.getQuery());
        System.out.println("Fragment: " + uri.getFragment());

    }
}
