package com.pitam;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class AddressClassification {
    public static void main(String[] args) {
        try {
            System.out.println("\n=== IP Address Classification Analysis ===");
            InetAddress addr = InetAddress.getLocalHost();
            // Check if the address is a wildcard address (0.0.0.0 for IPv4, :: for IPv6)
            System.out.println("Is any local address: " + addr.isAnyLocalAddress());
            // Check if the address is a loopback address (127.x.x.x for IPv4, ::1 for IPv6)
            System.out.println("Is loopback address: " + addr.isLoopbackAddress());
            // Check if the address is a site-local address (private network: 10.x.x.x, 172.16-31.x.x, 192.168.x.x)
            System.out.println("Is site local address: " + addr.isSiteLocalAddress());
            // Check if the address is a link-local address (169.254.x.x for IPv4, fe80::/10 for IPv6)
            System.out.println("Is link local address: " + addr.isLinkLocalAddress());
            // Check if the address is a multicast address (224.0.0.0-239.255.255.255 for IPv4)
            System.out.println("Is multicast address: " + addr.isMulticastAddress());
            // Analyze multicast scope (only relevant if the address is multicast)
            // Check if multicast address has global scope (can be routed across the internet)
            System.out.println("Is MC Global: " + addr.isMCGlobal());
            // Check if a multicast address is node-local scope (single machine only)
            System.out.println("Is MC Node Local: " + addr.isMCNodeLocal());
            // Check if a multicast address is link-local scope (single network segment)
            System.out.println("Is MC Link Local: " + addr.isMCLinkLocal());
            // Check if a multicast address is site-local scope (within organization/site)
            System.out.println("Is MC Site Local: " + addr.isMCSiteLocal());
            // Check if a multicast address is organization-local scope (within organization boundaries)
            System.out.println("Is MC Organization Local: " + addr.isMCOrgLocal());
        } catch (UnknownHostException e) {
            System.err.println("Network Error: Unable to resolve hostname - " + e.getMessage());
        }
    }
}
