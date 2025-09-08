package com.pitam;

import java.net.*;
import java.util.*;
public class InterfacesListener {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            System.out.println("Interface: " + iface);
        }
    }
}
