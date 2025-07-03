using System;
using System.Collections.Generic;

class ListExample
{
    public static void Lab27()
    {
        List<string> books = new List<string>();

        Console.WriteLine("=== Book Collection System ===\n");

        Console.Write("How many books would you like to add? ");
        int numBooks = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < numBooks; i++)
        {
            Console.Write($"Enter title of book {i + 1}: ");
            books.Add(Console.ReadLine());
        }

        Console.WriteLine("\nBooks added:");
        DisplayBooks(books);

        Console.WriteLine("\nAdding 3 more books using AddRange...");
        books.AddRange(new List<string> { "Hamlet", "Macbeth", "Othello" });
        DisplayBooks(books);

        Console.Write("\nEnter a book title to remove: ");
        string removeBook = Console.ReadLine();
        if (books.Remove(removeBook))
        {
            Console.WriteLine($"\nAfter removing '{removeBook}':");
            DisplayBooks(books);
        }
        else
        {
            Console.WriteLine($"'{removeBook}' not found.");
        }

        Console.Write("\nEnter index to remove (starting from 1): ");
        int removeIndex = Convert.ToInt32(Console.ReadLine()) - 1;
        if (removeIndex >= 0 && removeIndex < books.Count)
        {
            books.RemoveAt(removeIndex);
            Console.WriteLine("\nAfter RemoveAt():");
            DisplayBooks(books);
        }
        else
        {
            Console.WriteLine("Invalid index.");
        }

        Console.Write("\nEnter a book to insert: ");
        string insertBook = Console.ReadLine();
        Console.Write("Enter index to insert at (starting from 1): ");
        int insertIndex = Convert.ToInt32(Console.ReadLine()) - 1;

        if (insertIndex >= 0 && insertIndex <= books.Count)
        {
            books.Insert(insertIndex, insertBook);
            Console.WriteLine("\nAfter inserting:");
            DisplayBooks(books);
        }
        else
        {
            Console.WriteLine("Invalid index.");
        }

        books.Sort();
        Console.WriteLine("\nBooks after sorting alphabetically:");
        DisplayBooks(books);

        Console.WriteLine($"\nTotal number of books: {books.Count}");

        Console.Write("\nEnter a book title to search: ");
        string searchTitle = Console.ReadLine();
        int foundIndex = books.FindIndex(b => b.Equals(searchTitle, StringComparison.OrdinalIgnoreCase));

        if (foundIndex >= 0)
        {
            Console.WriteLine($"'{books[foundIndex]}' found at index {foundIndex + 1}.");
        }
        else
        {
            Console.WriteLine("Book not found.");
        }

        Console.Write("\nDo you want to clear all books? (yes/no): ");
        string clearInput = Console.ReadLine().ToLower();
        if (clearInput == "yes")
        {
            books.Clear();
            Console.WriteLine("Book list cleared.");
        }

        Console.WriteLine($"\nBooks remaining: {books.Count}");

        static void DisplayBooks(List<string> books)
        {
            if (books.Count == 0)
            {
                Console.WriteLine("No books in the collection.");
                return;
            }

            for (int i = 0; i < books.Count; i++)
            {
                Console.WriteLine($"{i + 1}. {books[i]}");
            }
        }
    }
}