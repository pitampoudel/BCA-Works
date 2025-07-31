using System;

class Lab1_7
{
    public static void execute()
    {
        Console.WriteLine("Pitam Poudel");
        int[,] matrix1 = new int[2, 2];
        int[,] matrix2 = new int[2, 2];
        int[,] result = new int[2, 2];

        // Input for the first matrix
        Console.WriteLine("Enter elements for the first 2x2 matrix:");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                Console.Write($"Matrix1[{i + 1}, {j + 1}]: ");
                matrix1[i, j] = Convert.ToInt32(Console.ReadLine());
            }
        }

        // Input for the second matrix
        Console.WriteLine("\nEnter elements for the second 2x2 matrix:");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                Console.Write($"Matrix2[{i + 1}, {j + 1}]: ");
                matrix2[i, j] = Convert.ToInt32(Console.ReadLine());
            }
        }

        // Print the first matrix
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                Console.Write(matrix1[i, j] + "\t");
            }
            Console.WriteLine();
        }

        // Print the second matrix
        Console.WriteLine("\n *");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                Console.Write(matrix2[i, j] + "\t");
            }
            Console.WriteLine();
        }
        Console.WriteLine("\n =");

        // Multiply the matrices
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                result[i, j] = 0; // Initialize the result cell
                for (int k = 0; k < 2; k++)
                {
                    result[i, j] += matrix1[i, k] * matrix2[k, j];
                }
            }
        }

        // Print the resultant matrix
        Console.WriteLine("\nThe resultant matrix after multiplication is:");
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                Console.Write(result[i, j] + "\t");
            }
            Console.WriteLine();
        }
    }
}