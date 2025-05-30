public delegate int AirthOperation(int x, int y);

class DelegateTest()
{
    int Sum(int x, int y)
    {
        return x + y;
    }

    int Diff(int x, int y)
    {
        return x - y;
    }

    public delegate T Transformer<T>(int x, int y);
    public void Execute()
    {
        AirthOperation sum = new(Sum);
        AirthOperation diff = new(Diff);
        int result = sum(1, 2) + diff(3, 2);
        Console.WriteLine($"result is {result}");
        Console.WriteLine($"sum is {sum(5, 6)}");
        Console.WriteLine($"diff is {diff(5, 6)}");
    }
}