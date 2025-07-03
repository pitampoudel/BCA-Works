using System;

class BankAccount
{
    // Data Members
    private string depositorName;
    private string accountNumber;
    private string accountType;
    private double balance;

    // Method to assign initial values
    public void AssignInitialValues(string name, string accNo, string type, double initialBalance)
    {
        depositorName = name;
        accountNumber = accNo;
        accountType = type;
        balance = initialBalance;

        Console.WriteLine("\nAccount created successfully!");
    }

    // Method to deposit money
    public void Deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            Console.WriteLine($"\nAmount of {amount} deposited successfully.");
        }
        else
        {
            Console.WriteLine("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void Withdraw(double amount)
    {
        if (amount <= 0)
        {
            Console.WriteLine("Withdrawal amount must be positive.");
        }
        else if (amount > balance)
        {
            Console.WriteLine("Insufficient balance. Withdrawal failed.");
        }
        else
        {
            balance -= amount;
            Console.WriteLine($"\nAmount of {amount} withdrawn successfully.");
        }
    }

    // Method to display account info
    public void Display()
    {
        Console.WriteLine("\n--- Account Summary ---");
        Console.WriteLine($"Depositor Name : {depositorName}");
        Console.WriteLine($"Account Number : {accountNumber}");
        Console.WriteLine($"Account Type   : {accountType}");
        Console.WriteLine($"Current Balance: {balance}");
    }
    public static void Lab3()
    {
        Console.WriteLine("Pitam Poudel \n");
        BankAccount account = new BankAccount();

        // Get initial account info from user
        Console.Write("Enter depositor name: ");
        string name = Console.ReadLine();

        Console.Write("Enter account number: ");
        string accNo = Console.ReadLine();

        Console.Write("Enter account type (Savings/Current): ");
        string type = Console.ReadLine();

        Console.Write("Enter initial balance: ");
        double initialBalance = double.Parse(Console.ReadLine());

        account.AssignInitialValues(name, accNo, type, initialBalance);

        // Deposit and Withdraw
        Console.Write("\nEnter amount to deposit: ");
        double depositAmount = double.Parse(Console.ReadLine());
        account.Deposit(depositAmount);

        Console.Write("\nEnter amount to withdraw: ");
        double withdrawAmount = double.Parse(Console.ReadLine());
        account.Withdraw(withdrawAmount);


        account.Display();
    }
}
