package com.pitam;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheck {

    public static void main(String[] args) {
        String ip = "102.0.2.1";
        checkSpam(ip);
    }

    public static void checkSpam(String ip) {
        String reversedIP = reverseIP(ip);
        String rblDomain = reversedIP + ".zen.spamhaus.org";
        try {
            InetAddress.getByName(rblDomain);
            System.out.println(ip + " is listed as a spammer!");
        } catch (UnknownHostException e) {
            System.out.println(ip + " is not listed as a spammer.");
        } catch (Exception e) {
            System.err.println("Error checking IP: " + e.getMessage());
        }
    }

    private static String reverseIP(String ip) {
        String[] parts = ip.split("\\.");
        return parts[3] + "." + parts[2] + "." + parts[1] + "." + parts[0];
    }
}
