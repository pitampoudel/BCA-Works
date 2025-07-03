using System;

class Palindrome
{
    public static void CheckPalindrome()
    {
        Console.WriteLine("Pitam Poudel");
        Console.Write("Enter a string to check if it's a palindrome: ");
        string input = Console.ReadLine();

        // Remove spaces and convert to lowercase for comparison
        string processedInput = input.Replace(" ", "").ToLower();

        // Reverse the string using a custom method
        string reversedInput = ReverseString(processedInput);

        if (processedInput == reversedInput)
        {
            Console.WriteLine($"'{input}' is a palindrome.");
        }
        else
        {
            Console.WriteLine($"'{input}' is not a palindrome.");
        }
    }

    // Custom method to reverse a string
    public static string ReverseString(string str)
    {
        char[] reversed = new char[str.Length];
        for (int i = 0, j = str.Length - 1; i < str.Length; i++, j--)
        {
            reversed[i] = str[j];
        }
        return new string(reversed);
    }
}