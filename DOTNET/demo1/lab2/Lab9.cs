using System;

// Base class
class Persons
{
    public string Name;
    public int Age;

    // Constructor
    public Persons(string name, int age)
    {
        Name = name;
        Age = age;
    }

    // Method to display person info
    public void DisplayInfo()
    {
        Console.WriteLine("Name: " + Name);
        Console.WriteLine("Age: " + Age);
    }
}

// Derived class
class Student : Persons
{
    public int StudentID;

    // Constructor using 'base' and 'this'
    public Student(string name, int age, int studentID) : base(name, age)
    {
        this.StudentID = studentID;  // 'this' refers to the current class's field
    }

    // Method to display student info
    public void DisplayStudentInfo()
    {
        base.DisplayInfo();  // Call method from base class
        Console.WriteLine("Student ID: " + this.StudentID);  // 'this' to access its own field
    }
}

class Thisbase
{
    public static void Run()
    {
        Console.Write("Enter student name: ");
        string name = Console.ReadLine();

        Console.Write("Enter student age: ");
        int age = Convert.ToInt32(Console.ReadLine());

        Console.Write("Enter student ID: ");
        int studentID = Convert.ToInt32(Console.ReadLine());

        Student student = new Student(name, age, studentID);

        Console.WriteLine("\n--- Student Information ---");
        student.DisplayStudentInfo();

        Console.ReadLine();
    }
}

// Wrapper class for lab2 index 9
class Lab2_9
{
    public static void Run() => Thisbase.Run();
}
