using System;

public class Lab1_1
{
    public static void execute()
    {
        Console.WriteLine("Pitam Poudel");

        Console.WriteLine("Enter three integers:");

        Console.Write("First number: ");
        int num1 = int.Parse(Console.ReadLine());

        Console.Write("Second number: ");
        int num2 = int.Parse(Console.ReadLine());

        Console.Write("Third number: ");
        int num3 = int.Parse(Console.ReadLine());

        int sum = num1 + num2 + num3;
        int product = num1 * num2 * num3;
        double average = sum / 3.0;

        Console.WriteLine($"\nSum: {sum}");
        Console.WriteLine($"Product: {product}");
        Console.WriteLine($"Average: {average:F2}");
    }
}
