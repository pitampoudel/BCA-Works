package com.pitam.lab;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Lab 11 - RMI Server
// Run this first, then run Lab11_RMIClient
public class Lab11_RMIServer {
    public static void main(String[] args) {
        try {
            Lab11_CalculatorImpl calculator = new Lab11_CalculatorImpl();

            // Create RMI registry on port 1099 (default)
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", calculator);

            System.out.println("RMI Server started. Calculator service bound on port 1099.");
            System.out.println("Waiting for client requests...");
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}