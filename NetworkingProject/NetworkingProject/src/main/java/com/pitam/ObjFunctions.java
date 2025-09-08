package com.pitam;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ObjFunctions {

    public static void main(String[] args) {
        try {
            InetAddress addr1 = InetAddress.getByName("pitam.com.np");
            InetAddress addr2 = InetAddress.getByName("pitampoudel.com.np");
            System.out.println("addr1==addr2: " + addr1.equals(addr2));
            System.out.println("addr1.hashCode(): " + addr1.hashCode());
            System.out.println("addr2.hashCode(): " + addr2.hashCode());
        } catch (UnknownHostException e) {
            System.err.println("Network Error: Unable to resolve hostname - " + e.getMessage());
        }
    }
}
