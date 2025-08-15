using System;

// Base class
class Vehicle
{
    public string Make;
    public string Model;

    public void DisplayInfo()
    {
        Console.WriteLine("Make: " + Make);
        Console.WriteLine("Model: " + Model);
    }
}

// Derived class from Vehicle
class Car : Vehicle
{
    public int NumberOfDoors;

    public void CarDoorInfo()
    {
        Console.WriteLine("Number of Doors: " + NumberOfDoors);
    }
}

// Derived class from Car (Multilevel Inheritance)
class ElectricCar : Car
{
    public int BatteryCapacity;

    public void ElectricCarBatteryInfo()
    {
        Console.WriteLine("Battery Capacity: " + BatteryCapacity + " kWh");
    }
}

class Multiinheritance
{
    public static void Run()
    {
        // Create an ElectricCar object
        ElectricCar myEV = new ElectricCar();
        Console.WriteLine("Pitam Poudel");

        // Set values for all fields
        myEV.Make = "Tesla";
        myEV.Model = "Model 3";
        myEV.NumberOfDoors = 4;
        myEV.BatteryCapacity = 75;

        // Display details from all levels of inheritance
        Console.WriteLine("Vehicle Info");
        myEV.DisplayInfo();

        Console.WriteLine("\nCar Door Info");
        myEV.CarDoorInfo();

        Console.WriteLine("\n Electric Car Info ");
        myEV.ElectricCarBatteryInfo();
    }
}

// Wrapper class for lab2 index 6
class Lab2_6
{
    public static void Run() => Multiinheritance.Run();
}

