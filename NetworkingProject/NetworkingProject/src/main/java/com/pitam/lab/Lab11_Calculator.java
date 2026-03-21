package com.pitam.lab;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Lab 11 - RMI Remote Interface
public interface Lab11_Calculator extends Remote {
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
    double divide(int a, int b) throws RemoteException;
}