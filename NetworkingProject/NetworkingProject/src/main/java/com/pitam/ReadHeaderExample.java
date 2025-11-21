package com.pitam;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ReadHeaderExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com");
        System.out.println("connecting to " + url);
        URLConnection conn = url.openConnection();
        conn.connect();

        System.out.println("connected to " + conn);
        System.out.println("-------HEADERS ----------");
        conn.getHeaderFields().forEach((k,v)->{
            System.out.println(k + ": " + v);
        });

    }
}
