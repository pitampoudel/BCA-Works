using System;
// Base class with different access modifiers
class Account
{
    public string AccountHolderName = "Pitam Poudel";           // public
    private double balance = 10000000;                          // private
    protected string accountType = "Savings Account";        // protected
    internal int branchCode = 101;                           // internal
    protected internal string bankName = "Nabil Bank";    // protected internal

    public void ShowPublicInfo()
    {
        Console.WriteLine("Account Holder: " + AccountHolderName);
    }

    private void ShowPrivateInfo()
    {
        Console.WriteLine("Balance: $" + balance);
    }

    protected void ShowProtectedInfo()
    {
        Console.WriteLine("Account Type: " + accountType);
    }

    internal void ShowInternalInfo()
    {
        Console.WriteLine("Branch Code: " + branchCode);
    }

    protected internal void ShowProtectedInternalInfo()
    {
        Console.WriteLine("Bank Name: " + bankName);
    }
}

// Derived class
class SavingsAccount : Account
{
    public void ShowDerivedAccess()
    {
        Console.WriteLine("\n--- Accessing from Derived Class ---");

        // Accessible:
        Console.WriteLine("Account Holder Name (public): " + AccountHolderName);
        Console.WriteLine("Account Type (protected): " + accountType);
        Console.WriteLine("Bank Name (protected internal): " + bankName);
        Console.WriteLine("Branch Code (internal): " + branchCode);

        // Method calls
        ShowProtectedInfo();
        ShowProtectedInternalInfo();
        ShowInternalInfo();

        // Not Accessible:
        // Console.WriteLine("Balance: " + balance); // Error (private)
        // ShowPrivateInfo(); // Error (private)
    }
}

class AccessModifiers
{
    public static void Lab21()
    {
        Console.WriteLine("Banking System - Access Modifiers Demo");
        Console.WriteLine("By Pitam Poudel\n");

        Account acc = new Account();
        SavingsAccount sa = new SavingsAccount();

        Console.WriteLine("--- Accessing from Main Method (Outside the class) ---");
        Console.WriteLine("Account Holder Name (public): " + acc.AccountHolderName);

        // Accessible within same assembly
        Console.WriteLine("Branch Code (internal): " + acc.branchCode);
        Console.WriteLine("Bank Name (protected internal): " + acc.bankName);

        acc.ShowPublicInfo();
        acc.ShowInternalInfo();
        acc.ShowProtectedInternalInfo();

        // Not accessible from outside:
        // Console.WriteLine(acc.accountType);       // Error (protected)
        // Console.WriteLine(acc.balance);           // Error (private)
        // acc.ShowPrivateInfo();                    // Error (private)
        // acc.ShowProtectedInfo();                  // Error (protected)

        // Call method in derived class
        sa.ShowDerivedAccess();
    }
}

