using System;

public class Lab1_10
{
    public static void CalculatePrimeSum()
    {
        Console.WriteLine("Pitam Poudel");
        int count = 0;
        int number = 2;
        int sum = 0;

        Console.WriteLine("The first 20 prime numbers are:");

        while (count < 20)
        {
            if (IsPrime(number))
            {
                Console.Write(number + " ");
                sum += number;
                count++;
            }
            number++;
        }

        Console.WriteLine($"\nThe sum of the first 20 prime numbers is: {sum}");
    }

    private static bool IsPrime(int num)
    {
        if (num < 2) return false;

        for (int i = 2; i <= Math.Sqrt(num); i++)
        {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}