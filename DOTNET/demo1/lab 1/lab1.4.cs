using System;

public class Lab1_4
{
    // Simple Fibonacci series generator
    public static void Play()
    {
        Console.WriteLine("Fibonacci Series Generator");
        Console.Write("Enter the number of terms to generate (positive integer): ");
        string? input = Console.ReadLine();

        if (!int.TryParse(input, out int n) || n <= 0)
        {
            Console.WriteLine("Invalid input. Please enter a positive integer.");
            return;
        }

        Console.WriteLine($"First {n} term(s) of the Fibonacci series:");

        long a = 0, b = 1;
        for (int i = 1; i <= n; i++)
        {
            Console.Write(a);
            if (i < n) Console.Write(", ");
            long next = a + b;
            a = b;
            b = next;
        }

        Console.WriteLine();
    }

    public static void Run() => Play();
}