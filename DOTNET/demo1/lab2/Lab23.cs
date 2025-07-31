using System;

// Generic class to store any type of data
class Storage<T>
{
    private T item;

    // Method to set the value
    public void SetItem(T value)
    {
        item = value;
    }

    // Method to get the value
    public T GetItem()
    {
        return item;
    }
}

// A sample custom class
class Product
{
    public string Name { get; set; }
    public double Price { get; set; }

    public override string ToString()
    {
        return $"Product Name: {Name}, Price: ${Price}";
    }
}

class GenericsDemo
{
    public static void Lab23()
    {
        Console.WriteLine("Generic Data Storage");
        Console.WriteLine("By Pitam Poudel\n");

        // Integer Storage with user input
        Console.Write("Enter an integer to store: ");
        int intInput = Convert.ToInt32(Console.ReadLine());
        Storage<int> intStorage = new Storage<int>();
        intStorage.SetItem(intInput);
        Console.WriteLine("Stored Integer: " + intStorage.GetItem());

        // String Storage with user input
        Console.Write("Enter a string to store: ");
        string stringInput = Console.ReadLine();
        Storage<string> stringStorage = new Storage<string>();
        stringStorage.SetItem(stringInput);
        Console.WriteLine("Stored String: " + stringStorage.GetItem());

        // Custom Object Storage with user input
        Console.Write("Enter product name: ");
        string productName = Console.ReadLine();
        Console.Write("Enter product price: ");
        double productPrice = Convert.ToDouble(Console.ReadLine());
        Product product = new Product { Name = productName, Price = productPrice };
        Storage<Product> productStorage = new Storage<Product>();
        productStorage.SetItem(product);
        Console.WriteLine("Stored Product: " + productStorage.GetItem());
    }
}

