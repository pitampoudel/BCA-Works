using System;

// Define a struct named Position
struct Position
{
    public int X;
    public int Y;

    // Constructor
    public Position(int x, int y)
    {
        X = x;
        Y = y;
    }

    // Method to display position
    public void Display()
    {
        Console.WriteLine($"Item is at position (X: {X}, Y: {Y})");
    }
}

class Structexample
{
    public static void Lab20()
    {
        Console.WriteLine(" Pitam Poudel\n");
        Console.WriteLine("Point of Sale (POS) System");

        Console.Write("Enter number of items to track: ");
        int itemCount = Convert.ToInt32(Console.ReadLine());

        Position[] items = new Position[itemCount];

        // Taking user input for item positions
        for (int i = 0; i < itemCount; i++)
        {
            Console.WriteLine($"\nEnter position for Item {i + 1}:");
            Console.Write("X: ");
            int x = Convert.ToInt32(Console.ReadLine());
            Console.Write("Y: ");
            int y = Convert.ToInt32(Console.ReadLine());

            items[i] = new Position(x, y);
        }

        // Display all positions
        Console.WriteLine("\nTouchscreen Item Positions:\n");
        for (int i = 0; i < itemCount; i++)
        {
            Console.Write($"Item {i + 1}: ");
            items[i].Display();
        }
    }
}

