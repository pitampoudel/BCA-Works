class LinqExample
{
    public static void Execute()
    {
        List<int> list = [1, 2, 3, 4, 5, 6];
        List<int> evenNumbers = list.FindAll(x => (x % 2) == 0);

        foreach (var num in evenNumbers)
        {
            Console.Write("{0}", num);
        }
    }
}
class LinqExample2
{
    public static void Execute()
    {
        List<string> names = ["Ram", "Shyam", "Mohan"];
        List<string> addresses = ["Btm", "Ktm", "Btm"];
        var result = names.Zip(addresses, (name, address) => new { name, address });

        foreach (var item in result)
        {
            Console.WriteLine("{0}", item);
        }
    }
}

