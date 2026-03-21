package com.pitam.lab;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Lab 11 - RMI Client
// Ensure Lab11_RMIServer is running before executing this
public class Lab11_RMIClient {
    public static void main(String[] args) {
        try {
            // Look up the registry on localhost port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Fetch the remote object
            Lab11_Calculator calculator = (Lab11_Calculator) registry.lookup("CalculatorService");

            System.out.println("=== RMI Calculator Client ===");
            System.out.println("10 + 5  = " + calculator.add(10, 5));
            System.out.println("10 - 5  = " + calculator.subtract(10, 5));
            System.out.println("10 * 5  = " + calculator.multiply(10, 5));
            System.out.println("10 / 5  = " + calculator.divide(10, 5));
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}