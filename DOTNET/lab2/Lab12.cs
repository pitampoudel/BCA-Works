using System;

class Box
{
    public double Length { get; set; }
    public double Width { get; set; }
    public double Height { get; set; }

    public Box(double length, double width, double height)
    {
        Length = length;
        Width = width;
        Height = height;
    }

    // Overload the + operator
    public static Box operator +(Box b1, Box b2)
    {
        return new Box(
            b1.Length + b2.Length,
            b1.Width + b2.Width,
            b1.Height + b2.Height
        );
    }

    public void DisplayVolume()
    {
        double volume = Length * Width * Height;
        Console.WriteLine("Volume of the box: " + volume);
    }
}

class Operatoroverloading
{
    public static void Lab12()
    {
        Console.WriteLine("Pitam Poudel");
        // Ask user for input for Box 1
        Console.WriteLine("Enter dimensions for Box 1:");
        Console.Write("Length: ");
        double length1 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Width: ");
        double width1 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Height: ");
        double height1 = Convert.ToDouble(Console.ReadLine());

        Box box1 = new Box(length1, width1, height1);

        // Ask user for input for Box 2
        Console.WriteLine("\nEnter dimensions for Box 2:");
        Console.Write("Length: ");
        double length2 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Width: ");
        double width2 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Height: ");
        double height2 = Convert.ToDouble(Console.ReadLine());

        Box box2 = new Box(length2, width2, height2);

        // Add the boxes and display volume
        Box box3 = box1 + box2;
        Console.WriteLine("\nAfter adding both boxes:");
        box3.DisplayVolume();
    }
}
