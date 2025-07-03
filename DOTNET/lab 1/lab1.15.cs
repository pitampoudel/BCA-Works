using System;

public class RefOutDemo
{
    // Method using ref keyword
    public static void IncrementByRef(ref int number)
    {
        number += 10;
    }

    // Method using out keyword
    public static void CalculateSumAndProduct(int a, int b, out int sum, out int product)
    {
        sum = a + b;
        product = a * b;
    }

    public static void Demonstrate()
    {
        Console.WriteLine("Pitam Poudel");
        Console.WriteLine("Demonstrating ref and out keywords:");

        // Using ref
        Console.Write("Enter the number: ");
        int number = int.Parse(Console.ReadLine());
        Console.WriteLine($"Original number: {number}");
        IncrementByRef(ref number);
        Console.WriteLine($"After IncrementByRef: {number}");

        // Using out
        Console.Write("Enter First number: ");
        int a = int.Parse(Console.ReadLine());
        Console.Write("Enter Second number: ");
        int b = int.Parse(Console.ReadLine());
        CalculateSumAndProduct(a, b, out int sum, out int product);
        Console.WriteLine($"Sum of {a} and {b}: {sum}");
        Console.WriteLine($"Product of {a} and {b}: {product}");
    }
}