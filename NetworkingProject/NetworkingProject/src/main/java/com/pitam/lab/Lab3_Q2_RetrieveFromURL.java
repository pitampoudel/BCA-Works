package com.pitam.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

// Lab 3 - Q2: WAP to retrieve data from a URL.
public class Lab3_Q2_RetrieveFromURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            System.out.println("Fetching data from: " + url);
            System.out.println("==============================");

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null && lineCount < 20) {
                System.out.println(line);
                lineCount++;
            }

            reader.close();
            System.out.println("==============================");
            System.out.println("(Showing first 20 lines)");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}