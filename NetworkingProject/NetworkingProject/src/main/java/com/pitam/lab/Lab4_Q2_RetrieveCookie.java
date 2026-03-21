package com.pitam.lab;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

// Lab 4 - Q2: WAP to retrieve a cookie's data.
public class Lab4_Q2_RetrieveCookie {
    public static void main(String[] args) throws Exception {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        URI uri = new URI("http://example.com");

        // Add some cookies to the store
        HttpCookie cookie1 = new HttpCookie("username", "pitam");
        cookie1.setDomain("example.com");
        cookie1.setPath("/");

        HttpCookie cookie2 = new HttpCookie("sessionId", "abc123xyz");
        cookie2.setDomain("example.com");
        cookie2.setPath("/");

        cookieManager.getCookieStore().add(uri, cookie1);
        cookieManager.getCookieStore().add(uri, cookie2);

        // Retrieve all cookies for the URI
        List<HttpCookie> cookies = cookieManager.getCookieStore().get(uri);

        System.out.println("=== Retrieved Cookies for " + uri + " ===");
        for (HttpCookie cookie : cookies) {
            System.out.println("Name  : " + cookie.getName());
            System.out.println("Value : " + cookie.getValue());
            System.out.println("---");
        }
    }
}