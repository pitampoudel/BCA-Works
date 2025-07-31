using System;

public class Lab1_9
{
    public static void CalculateFactorial()
    {
        Console.WriteLine("Pitam Poudel");

        Console.Write("Enter a number to find its factorial: ");
        int number = int.Parse(Console.ReadLine());

        if (number < 0)
        {
            Console.WriteLine("Factorial is not defined for negative numbers.");
            return;
        }

        long factorial = 1;
        for (int i = 1; i <= number; i++)
        {
            factorial *= i;
        }

        Console.WriteLine($"The factorial of {number} is: {factorial}");
    }
}