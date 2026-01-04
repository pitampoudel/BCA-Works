package com.pitam;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface Calculator extends Remote {
    int add(int a, int b) throws java.rmi.RemoteException;
}


class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws java.rmi.RemoteException {
        return a + b;
    }
}

class RemoteServer {
    public static void main(String[] args) {
        try {
           Registry registry= LocateRegistry.createRegistry(1099);
            CalculatorImpl calc = new CalculatorImpl();
            registry.rebind("CalculatorService", calc);
            System.out.println("Calculator Service is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RemoteClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calc = (Calculator) registry.lookup("CalculatorService");
            int result = calc.add(5, 3);
            System.out.println("Result of 5 + 3 = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}