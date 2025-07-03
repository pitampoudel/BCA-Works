using System;

class CurrencyConverter
{
    // Static fields for exchange rates
    private static double usdToNprRate = 132.0;
    private static double inrToNprRate = 1.6;

    // Static method to convert USD to NPR
    public static double ConvertUsdToNpr(double usdAmount)
    {
        return usdAmount * usdToNprRate;
    }

    // Static method to convert INR to NPR
    public static double ConvertInrToNpr(double inrAmount)
    {
        return inrAmount * inrToNprRate;
    }

    public static void Lab1()
    {
        Console.WriteLine("Pitam Poudel\n");
        Console.WriteLine("Currency Converter - Convert to NPR\n");

        Console.Write("Enter amount in USD: ");
        double usd = Convert.ToDouble(Console.ReadLine());

        // Ask user for INR amount
        Console.Write("Enter amount in INR: ");
        double inr = Convert.ToDouble(Console.ReadLine());

        // Call static methods without creating an object
        double nprFromUsd = CurrencyConverter.ConvertUsdToNpr(usd);
        double nprFromInr = CurrencyConverter.ConvertInrToNpr(inr);

        // Display the results
        Console.WriteLine($"{usd} USD = {nprFromUsd} NPR");
        Console.WriteLine($"{inr} INR = {nprFromInr} NPR");

        Console.WriteLine("\nThank you for using the Currency Converter!");
    }
}
