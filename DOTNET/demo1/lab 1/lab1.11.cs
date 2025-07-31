using System;

public class Lab1_11
{
    public static void RemoveEven()
    {
        Console.WriteLine("Pitam Poudel");

        Console.Write("Enter the size of the array: ");
        int size = int.Parse(Console.ReadLine());

        int[] array = new int[size];
        Console.WriteLine("Enter the elements of the array:");
        for (int i = 0; i < size; i++)
        {
            Console.Write($"Element {i + 1}: ");
            array[i] = int.Parse(Console.ReadLine());
        }

        Console.WriteLine("Original Array: " + string.Join(", ", array));

        Console.Write("Array after removing even elements: ");
        for (int i = 0; i < size; i++)
        {
            if (array[i] % 2 != 0) // Check if the element is odd
            {
                Console.Write(array[i] + " ");
            }
        }
        Console.WriteLine();
    }
}