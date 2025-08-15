using System;

class Lab1_6
{
    public static void execute()
    {
        Console.WriteLine("Pitam Poudel");
        Console.WriteLine("Choose the conversion type:");
        Console.WriteLine("1. Celsius to Fahrenheit");
        Console.WriteLine("2. Fahrenheit to Celsius");
        Console.Write("Enter your choice (1 or 2): ");
        int choice = int.Parse(Console.ReadLine());

        switch (choice)
        {
            case 1:
                ConvertCelsiusToFahrenheit();
                break;
            case 2:
                ConvertFahrenheitToCelsius();
                break;
            default:
                Console.WriteLine("Invalid choice. Please enter 1 or 2.");
                break;
        }
    }

    private static void ConvertCelsiusToFahrenheit()
    {
        Console.Write("Enter temperature in Celsius: ");
        if (double.TryParse(Console.ReadLine(), out double celsius))
        {
            double fahrenheit = (celsius * 9 / 5) + 32;
            Console.WriteLine($"{celsius}°C is equal to {fahrenheit}°F.");
        }
        else
        {
            Console.WriteLine("Invalid input. Please enter a valid number.");
        }
    }

    private static void ConvertFahrenheitToCelsius()
    {
        Console.Write("Enter temperature in Fahrenheit: ");
        if (double.TryParse(Console.ReadLine(), out double fahrenheit))
        {
            double celsius = (fahrenheit - 32) * 5 / 9;
            Console.WriteLine($"{fahrenheit}°F is equal to {celsius}°C.");
        }
        else
        {
            Console.WriteLine("Invalid input. Please enter a valid number.");
        }
    }

    public static void Run() => execute();
}