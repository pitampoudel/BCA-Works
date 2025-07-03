using System;
// Base class
class Employee
{
    public int EmployeeID;
    public string Name;

    public Employee(int employeeID, string name)
    {
        EmployeeID = employeeID;
        Name = name;
    }

    public void DisplayEmployeeInfo()
    {
        Console.WriteLine("Employee ID: " + EmployeeID);
        Console.WriteLine("Name: " + Name);
    }
}

// Derived class: Manager
class Manager : Employee
{
    public Manager(int employeeID, string name)
        : base(employeeID, name)
    {
    }

    public void DisplayManagerInfo()
    {
        Console.WriteLine("Role: Manager");
        DisplayEmployeeInfo();
    }
}

// Derived class: Developer
class Developer : Employee
{
    public Developer(int employeeID, string name)
        : base(employeeID, name)
    {
    }

    public void DisplayDeveloperInfo()
    {
        Console.WriteLine("Role: Developer");
        DisplayEmployeeInfo();
    }
}

class MultiLevelInheritance
{
    public static void Lab7()
    {
        Console.WriteLine("Pitam Poudel multi level cooperation\n");
        // Input for Manager
        Console.WriteLine("Enter Manager Details:");
        Console.Write("Employee ID: ");
        int mgrID = Convert.ToInt32(Console.ReadLine());

        Console.Write("Name: ");
        string mgrName = Console.ReadLine();

        Manager mgr = new Manager(mgrID, mgrName);

        Console.WriteLine();

        // Input for Developer
        Console.WriteLine("Enter Developer Details:");
        Console.Write("Employee ID: ");
        int devID = Convert.ToInt32(Console.ReadLine());

        Console.Write("Name: ");
        string devName = Console.ReadLine();

        Developer dev = new Developer(devID, devName);

        Console.WriteLine("\n--- Manager Info ---");
        mgr.DisplayManagerInfo();

        Console.WriteLine("\n--- Developer Info ---");
        dev.DisplayDeveloperInfo();
    }
}

