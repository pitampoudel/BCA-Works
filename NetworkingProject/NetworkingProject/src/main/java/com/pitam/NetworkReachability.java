package com.pitam;

import java.net.InetAddress;

public class NetworkReachability {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("godaan.com.np");
            System.out.println("Reachable: " + addr.isReachable(1000));
            System.out.println(addr);
        } catch (Exception e) {
            System.err.println("Error:  " + e.getMessage());
        }
    }
}
