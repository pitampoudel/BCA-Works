using System;

class BankAccounts
{
    public double Balance;

    // Deposit method - version 1
    public void Deposit(double amount)
    {
        Balance += amount;
        Console.WriteLine($"Deposited: ${amount}");
    }

    // Deposit method - version 2 (Overloaded with description)
    public void Deposit(double amount, string description)
    {
        Balance += amount;
        Console.WriteLine($"Deposited: ${amount} - {description}");
    }

    public void ShowBalance()
    {
        Console.WriteLine($"Current Balance: ${Balance}");
    }
}

class Methodoverloading
{
    public static void Lab10()
    {
        Console.WriteLine("Pitam Poudel\n");
        BankAccounts account = new BankAccounts();

        Console.Write("Enter amount to deposit: ");
        double amount1 = Convert.ToDouble(Console.ReadLine());
        account.Deposit(amount1); // Call first version

        Console.Write("Enter amount to deposit: ");
        double amount2 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Enter transaction description: ");
        string description = Console.ReadLine();
        account.Deposit(amount2, description); // Call overloaded version

        Console.WriteLine();
        account.ShowBalance();

        Console.ReadLine();
    }
}
