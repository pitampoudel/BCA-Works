using System;

// Base class
class Machine
{
    public string Brand;

    public void Start()
    {
        Console.WriteLine($"Machine ({Brand}) has started.");
    }
}

// Interface
interface IScanner
{
    void ScanDocument();
}

// Derived class that inherits from Machine and implements IScanner
class SmartPrinter : Machine, IScanner
{
    // Implementing the ScanDocument method
    public void ScanDocument()
    {
        Console.WriteLine($"SmartPrinter ({Brand}) is scanning a document...");
        // Simulate scan complete
        Console.WriteLine("Scanning completed successfully.");
    }
}

class MultipleInheritance
{
    public static void Lab8()
    {
        Console.WriteLine("Pitam Poudel \n");
        // Create an instance of SmartPrinter
        SmartPrinter printer = new SmartPrinter();

        // Set the brand of the printer
        Console.Write("Enter the brand of the SmartPrinter: ");
        printer.Brand = Console.ReadLine();

        Console.WriteLine();
        printer.Start();           // Method from Machine class
        printer.ScanDocument();   // Method from IScanner interface

        Console.ReadLine();
    }
}
