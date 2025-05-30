using static System.Console;

public class IterateUtils
{
    public static void Execute()
    {
        int[] arr = [1, 2, 3, 4, 5];

        for (int i = 4; i >= 0; i--)
        {
            Console.WriteLine(arr[i]);
        }
        Console.WriteLine("-----");

        foreach (int i in arr)
        {
            Console.WriteLine(i);
        }
        Console.WriteLine("-----");

        int index = 0;
    startloop:
        if (index < arr.Length)
        {
            Console.WriteLine(arr[index]);
            index++;
            goto startloop;
        }
    }

}
