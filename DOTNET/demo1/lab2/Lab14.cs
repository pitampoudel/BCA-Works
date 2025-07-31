using System;

// Base class
class Person
{
    public string Name { get; set; }

    public Person(string name)
    {
        Name = name;
    }

    public void ShowBasicInfo()
    {
        Console.WriteLine("Person Name: " + Name);
    }
}

// Derived class
class Doctor : Person
{
    public string Specialization { get; set; }

    public Doctor(string name, string specialization) : base(name)
    {
        Specialization = specialization;
    }

    public void ShowDoctorInfo()
    {
        Console.WriteLine("Specialization: " + Specialization);
    }
}

class Updowncasting
{
    public static void Lab14()
    {
        Console.WriteLine("Pitam Poudel");
        // Ask the user for input
        Console.WriteLine("Enter Doctor's Name:");
        string name = Console.ReadLine();

        Console.WriteLine("Enter Doctor's Specialization:");
        string specialization = Console.ReadLine();

        // Create a Doctor object with user input
        Doctor doc = new Doctor(name, specialization);

        // --- Upcasting ---
        Person personRef = doc; // Upcasting
        Console.WriteLine("\n--- Upcasting Output ---");
        personRef.ShowBasicInfo(); // Only base class method available

        // --- Downcasting ---
        Doctor downcastedDoc = (Doctor)personRef; // Downcasting
        Console.WriteLine("\n--- Downcasting Output ---");
        downcastedDoc.ShowDoctorInfo(); // Accessing derived class method

        Console.ReadLine();
    }
}
