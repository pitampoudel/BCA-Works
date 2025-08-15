using System;
using System.Collections.Generic;

class Dictionary
{
    public static void Run()
    {
        Console.WriteLine("Student Grade Management System");
        Console.WriteLine("By Pitam Poudel\n");

        // Create a dictionary to store student names and grades
        Dictionary<string, int> studentGrades = new Dictionary<string, int>();

        Console.Write("How many students do you want to add? ");
        int numberOfStudents = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < numberOfStudents; i++)
        {
            Console.Write($"\nEnter name of student {i + 1}: ");
            string name = Console.ReadLine();

            Console.Write($"Enter grade for {name}: ");
            int grade = Convert.ToInt32(Console.ReadLine());

            // Add the student-grade pair to the dictionary
            try
            {
                studentGrades.Add(name, grade);
            }
            catch (ArgumentException)
            {
                Console.WriteLine("This student already exists! Skipping...");
            }
        }

        // Display total number of students
        Console.WriteLine($"\nTotal Students Added: {studentGrades.Count}");

        // Display all students and their grades
        Console.WriteLine("\nStudent Grades:");
        foreach (var entry in studentGrades)
        {
            Console.WriteLine($"Name: {entry.Key}, Grade: {entry.Value}");
        }
    }
}

// Wrapper class for lab2 index 24
class Lab2_24
{
    public static void Run() => Dictionary.Run();
}

