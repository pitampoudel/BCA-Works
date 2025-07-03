using System;
using System.Collections;

class ArrayListExample
{
    public static void Lab28()
    {
        ArrayList movies = new ArrayList();

        Console.WriteLine("=== Movie Collection System ===\n");

        Console.Write("How many movies do you want to add? ");
        int n = Convert.ToInt32(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            Console.Write($"Enter movie {i + 1} title: ");
            movies.Add(Console.ReadLine());
        }

        Console.WriteLine("\nMovies Added:");
        DisplayMovies(movies);

        Console.WriteLine("\nAdding some default movies using AddRange...");
        movies.AddRange(new ArrayList { "Titanic", "Inception", "Interstellar" });
        DisplayMovies(movies);

        Console.Write("\nEnter a movie to remove: ");
        string removeMovie = Console.ReadLine();
        if (movies.Contains(removeMovie))
        {
            movies.Remove(removeMovie);
            Console.WriteLine($"\n'{removeMovie}' removed.");
        }
        else
        {
            Console.WriteLine("Movie not found.");
        }
        DisplayMovies(movies);

        Console.Write("\nEnter index to remove (starting from 1): ");
        int removeIndex = Convert.ToInt32(Console.ReadLine()) - 1;
        if (removeIndex >= 0 && removeIndex < movies.Count)
        {
            movies.RemoveAt(removeIndex);
            Console.WriteLine("Movie removed at that index.");
        }
        else
        {
            Console.WriteLine("Invalid index.");
        }
        DisplayMovies(movies);

        Console.Write("\nEnter a movie to insert: ");
        string insertMovie = Console.ReadLine();
        Console.Write("Enter index to insert at (starting from 1): ");
        int insertIndex = Convert.ToInt32(Console.ReadLine()) - 1;
        if (insertIndex >= 0 && insertIndex <= movies.Count)
        {
            movies.Insert(insertIndex, insertMovie);
            Console.WriteLine("Movie inserted.");
        }
        else
        {
            Console.WriteLine("Invalid index.");
        }
        DisplayMovies(movies);

        movies.Sort();
        Console.WriteLine("\nMovies after sorting alphabetically:");
        DisplayMovies(movies);

        Console.WriteLine($"\nTotal number of movies: {movies.Count}");

        Console.Write("\nEnter a movie title to search: ");
        string searchMovie = Console.ReadLine();
        int foundIndex = movies.IndexOf(searchMovie);
        if (foundIndex >= 0)
        {
            Console.WriteLine($"'{searchMovie}' found at position {foundIndex + 1}.");
        }
        else
        {
            Console.WriteLine("Movie not found.");
        }

        Console.Write("\nDo you want to clear the movie list? (yes/no): ");
        string clearChoice = Console.ReadLine().ToLower();
        if (clearChoice == "yes")
        {
            movies.Clear();
            Console.WriteLine("Movie list cleared.");
        }

        Console.WriteLine($"\nFinal movie count: {movies.Count}");
    }

    static void DisplayMovies(ArrayList movies)
    {
        if (movies.Count == 0)
        {
            Console.WriteLine("No movies in the collection.");
            return;
        }

        for (int i = 0; i < movies.Count; i++)
        {
            Console.WriteLine($"{i + 1}. {movies[i]}");
        }
    }
}
