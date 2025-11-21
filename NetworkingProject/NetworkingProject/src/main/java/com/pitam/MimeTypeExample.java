package com.pitam;

import java.net.URLConnection;

public class MimeTypeExample {

    public static void main(String[] args) {
        String type = URLConnection.guessContentTypeFromName("image1.jpg");
        System.out.println(type);
    }
}
