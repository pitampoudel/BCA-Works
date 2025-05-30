static class College
{
    private static readonly string name = "Ambition";
    private static readonly string address = "Baneshwor";

    public static void DisplayDetails()
    {
        Console.WriteLine($"My college name is {name} and address is {address}");

    }

}

class StaticDemo
{
    static void Execute()
    {
        // Wrong
        // College c = new College();
        // c.DisplayDetails();

        // Right
        College.DisplayDetails();
    }

}

