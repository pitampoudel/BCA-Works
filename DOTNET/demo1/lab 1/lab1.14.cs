using System;

public class Lab1_14
{
    public int Feet { get; set; }
    public int Inches { get; set; }

    public void Distance(int feet, int inches)
    {
        Feet = feet;
        Inches = inches;
        Normalize();
    }

    // Overload the + operator
    public static Distance operator +(Distance d1, Distance d2)
    {
        int totalFeet = d1.Feet + d2.Feet;
        int totalInches = d1.Inches + d2.Inches;
        return new Distance(totalFeet, totalInches);
    }

    // Normalize the distance (convert inches to feet if >= 12)
    private void Normalize()
    {
        if (Inches >= 12)
        {
            //how
            Feet += Inches / 12;
            Inches %= 12;
        }
    }

    public override string ToString()
    {
        return $"{Feet} feet {Inches} inches";
    }

    public static void AddDistances()
    {
        Console.WriteLine("Pitam Poudel");
        Console.WriteLine("Enter the first distance:");
        Console.Write("Feet: ");
        int feet1 = int.Parse(Console.ReadLine());
        Console.Write("Inches: ");
        int inches1 = int.Parse(Console.ReadLine());

        Console.WriteLine("Enter the second distance:");
        Console.Write("Feet: ");
        int feet2 = int.Parse(Console.ReadLine());
        Console.Write("Inches: ");
        int inches2 = int.Parse(Console.ReadLine());

        Distance d1 = new Distance(feet1, inches1);
        Distance d2 = new Distance(feet2, inches2);

        Distance result = d1 + d2;

        Console.WriteLine($"The sum of the distances is: {result}");
    }
}