using System;
using System.Collections.Generic;

class Queue
{
    public static void Lab25()
    {
        Console.WriteLine("Customer Service Queue System");
        Console.WriteLine("By Pitam Poudel\n");

        // Create a queue to hold customer names
        Queue<string> customerQueue = new Queue<string>();

        // Enqueue customers
        Console.Write("How many customers are arriving initially? ");
        int initialCount = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < initialCount; i++)
        {
            Console.Write($"Enter name of customer {i + 1}: ");
            string name = Console.ReadLine();
            customerQueue.Enqueue(name);
        }

        // Dequeue a few customers
        Console.Write("\nHow many customers should be served now? ");
        int serveCount = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < serveCount && customerQueue.Count > 0; i++)
        {
            string served = customerQueue.Dequeue();
            Console.WriteLine($"Served Customer: {served}");
        }

        // Peek at the next customer
        if (customerQueue.Count > 0)
        {
            Console.WriteLine($"\nNext customer in line: {customerQueue.Peek()}");
        }
        else
        {
            Console.WriteLine("\nNo customers left in the queue.");
        }

        // Add more customers
        Console.Write("\nHow many more customers are arriving? ");
        int newCount = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < newCount; i++)
        {
            Console.Write($"Enter name of new customer {i + 1}: ");
            string name = Console.ReadLine();
            customerQueue.Enqueue(name);
        }

        // Serve all remaining customers
        Console.WriteLine("\nServing all remaining customers:");
        while (customerQueue.Count > 0)
        {
            string served = customerQueue.Dequeue();
            Console.WriteLine($"Served Customer: {served}");
        }

        Console.WriteLine("\nAll customers have been served.");
    }
}

