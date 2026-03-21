package com.pitam.lab;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

// Lab 4 - Q1: WAP to set a cookie.
public class Lab4_Q1_SetCookie {
    public static void main(String[] args) throws Exception {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        // Create and add a cookie manually
        HttpCookie cookie = new HttpCookie("username", "pitam");
        cookie.setDomain("example.com");
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour

        URI uri = new URI("http://example.com");
        cookieManager.getCookieStore().add(uri, cookie);

        System.out.println("Cookie set successfully!");
        System.out.println("Name   : " + cookie.getName());
        System.out.println("Value  : " + cookie.getValue());
        System.out.println("Domain : " + cookie.getDomain());
        System.out.println("Path   : " + cookie.getPath());
        System.out.println("MaxAge : " + cookie.getMaxAge() + " seconds");
    }
}