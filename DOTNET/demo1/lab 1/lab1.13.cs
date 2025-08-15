using System;

public class Lab1_13
{
    public static void HandleDivideByZero()
    {
        Console.WriteLine("Pitam Poudel");
        try
        {
            Console.WriteLine("Enter the numerator:");
            int numerator = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter the denominator:");
            int denominator = int.Parse(Console.ReadLine());

            int result = numerator / denominator;
            Console.WriteLine($"Result: {result}");
        }
        catch (DivideByZeroException)
        {
            Console.WriteLine("Error: Division by zero is not allowed.");
        }
        catch (FormatException)
        {
            Console.WriteLine("Error: Please enter valid integers.");
        }
        finally
        {
            Console.WriteLine("Division operation completed.");
        }
    }

    // Uniform entrypoint
    public static void Run() => HandleDivideByZero();
}