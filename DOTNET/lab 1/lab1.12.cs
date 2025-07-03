using System;

public class StringMethods
{
    public static void Demonstrate()
    {
        Console.WriteLine("Pitam Poudel");

        Console.WriteLine("Enter a string:");
        string str = Console.ReadLine();

        Console.WriteLine($"Original String: {str}");
        Console.WriteLine($"Length: {str.Length}");
        Console.WriteLine($"ToUpper: {str.ToUpper()}");
        Console.WriteLine($"ToLower: {str.ToLower()}");
        Console.WriteLine($"Contains 'World': {str.Contains("World")}");
        Console.WriteLine($"IndexOf 'World': {str.IndexOf("World")}");

        int firstSpaceIndex = str.IndexOf(' ');
        if (firstSpaceIndex != -1)
        {
            string replacedString = "Replaced" + str.Substring(firstSpaceIndex);
            Console.WriteLine($"Replace first word with 'Replaced': {replacedString}");
        }
        else
        {
            Console.WriteLine($"Replace first word with 'Replaced': Replaced");
        }

        string[] words = str.Split(' ');
        Console.WriteLine("Split:");
        foreach (string word in words)
        {
            Console.WriteLine(word);
        }

        string joinedString = string.Join("-", words);
        Console.WriteLine($"Join: {joinedString}");
    }
}