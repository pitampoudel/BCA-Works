using System;

class Person1
{
    // Fields
    private string name;
    private int age;
    private string address;

    // Constructor 1: Only name
    public Person1(string name)
    {
        this.name = name;
        this.age = 0;
        this.address = "Not provided";
    }

    // Constructor 2: Name and age
    public Person1(string name, int age)
    {
        this.name = name;
        this.age = age;
        this.address = "Not provided";
    }

    // Constructor 3: Name, age, and address
    public Person1(string name, int age, string address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Method to display person details
    public void DisplayInfo()
    {
        Console.WriteLine("\nPerson Details:");
        Console.WriteLine("Name: " + name);
        Console.WriteLine("Age: " + age);
        Console.WriteLine("Address: " + address);
    }
    public static void Run()
    {
        Console.WriteLine("Pitam Poudel");
        // Ask user for input
        Console.Write("Enter name: ");
        string name = Console.ReadLine();

        Console.Write("Enter age: ");
        int age = Convert.ToInt32(Console.ReadLine());

        Console.Write("Enter address: ");
        string address = Console.ReadLine();

        // Create Person object using all three inputs
        Person1 person = new Person1(name);
        person.DisplayInfo();
        Person1 person1 = new Person1(name, age);
        person1.DisplayInfo();
        Person1 person2 = new Person1(name, age, address);
        person2.DisplayInfo();

        Console.ReadLine();
    }
}

// Wrapper class for lab2 index 4
class Lab2_4
{
    public static void Run() => Person1.Run();
}
