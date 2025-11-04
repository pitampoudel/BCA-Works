package com.pitam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlContentReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            InputStream isr = url.openStream();
            InputStreamReader br = new InputStreamReader(isr);
            BufferedReader reader = new BufferedReader(br);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (RuntimeException | MalformedURLException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
