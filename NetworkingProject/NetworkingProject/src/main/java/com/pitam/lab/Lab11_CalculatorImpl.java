package com.pitam.lab;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Lab 11 - RMI Implementation of the Calculator interface
public class Lab11_CalculatorImpl extends UnicastRemoteObject implements Lab11_Calculator {

    protected Lab11_CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) throw new RemoteException("Division by zero is not allowed.");
        return (double) a / b;
    }
}