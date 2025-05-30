class ExceptionTest
{
    static void Display(string? name)
    {
        if (name == null)
        {
            throw new ArgumentNullException(nameof(name), "Name cannot be null");
        }
        Console.WriteLine($"Hello, {name}!");

    }
    public static void Execute()
    {

        try
        {
            Display(null);
        }
        catch (ArgumentNullException ex)
        {
            Console.WriteLine($"Caught an exception: {ex.Message}");
            Console.WriteLine($"Parameter name: {ex.ParamName}");
        }

    }
}