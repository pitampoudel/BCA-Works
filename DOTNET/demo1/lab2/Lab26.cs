using System;
using System.Collections.Generic;

class StackExample
{
    public static void Lab26()
    {
        Console.WriteLine("Browser History System using Stack");
        Console.WriteLine("By Pitam Poudel\n");

        Stack<string> historyStack = new Stack<string>();

        // Add some initial pages using Push()
        Console.Write("How many web pages do you want to visit initially? ");
        int pageCount = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < pageCount; i++)
        {
            Console.Write($"Enter URL of page {i + 1}: ");
            string url = Console.ReadLine();
            historyStack.Push(url);
        }

        // Show current page using Peek()
        if (historyStack.Count > 0)
        {
            Console.WriteLine($"\nCurrent Page: {historyStack.Peek()}");
        }

        // Go back by popping the top page
        Console.Write("\nDo you want to go back to the previous page? (yes/no): ");
        string goBack = Console.ReadLine().ToLower();
        if (goBack == "yes" && historyStack.Count > 0)
        {
            string popped = historyStack.Pop();
            Console.WriteLine($"Went back from: {popped}");
            if (historyStack.Count > 0)
                Console.WriteLine($"Now on Page: {historyStack.Peek()}");
            else
                Console.WriteLine("No more history available.");
        }

        // Check if a specific page is in the history
        Console.Write("\nEnter a URL to check if it's in history: ");
        string checkUrl = Console.ReadLine();
        if (historyStack.Contains(checkUrl))
            Console.WriteLine("Yes, the URL is in your browsing history.");
        else
            Console.WriteLine("No, the URL is not in your browsing history.");

        // Clear history
        Console.Write("\nDo you want to clear all browsing history? (yes/no): ");
        string clearHistory = Console.ReadLine().ToLower();
        if (clearHistory == "yes")
        {
            historyStack.Clear();
            Console.WriteLine("All browsing history cleared.");
        }

        // Final status
        Console.WriteLine($"\nTotal pages in history now: {historyStack.Count}");
        if (historyStack.Count > 0)
        {
            Console.WriteLine("Remaining Pages in History:");
            foreach (string url in historyStack)
            {
                Console.WriteLine(url);
            }
        }
        else
        {
            Console.WriteLine("Browsing history is empty.");
        }
    }
}

