using System;

public class Lab1_3
{
    public static void Play()
    {
        Console.WriteLine("Pitam Poudel");
        string secretString = "Pitam";
        int attempts = 3;

        Console.WriteLine("Welcome to the Guess the Secret String Game!");
        Console.WriteLine($"You have {attempts} attempts to guess the secret string.");

        while (attempts > 0)
        {
            Console.Write("\nEnter your guess: ");
            string userGuess = Console.ReadLine() ?? string.Empty;

            if (userGuess.Equals(secretString, StringComparison.OrdinalIgnoreCase))
            {
                Console.WriteLine("Congratulations! You guessed the secret string correctly!");
                return;
            }
            else
            {
                attempts--;
                Console.WriteLine($"Wrong guess. You have {attempts} attempts left.");
            }
        }

        Console.WriteLine("\nSorry, you've used all your attempts. The secret string was: " + secretString);
    }
}