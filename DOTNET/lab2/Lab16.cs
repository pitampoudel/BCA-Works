using System;

// Base class
class Account1
{
    public int AccountNumber;

    public virtual void CalculateInterest()
    {
        Console.WriteLine("Interest calculated in base Account class.");
    }
}

// Derived class with sealed override
class FixedDepositAccount : Account1
{
    public sealed override void CalculateInterest()
    {
        Console.WriteLine("Interest calculated for Fixed Deposit Account.");
    }
}

class SpecialFixedDepositAccount : FixedDepositAccount
{
    public override void CalculateInterest()
    {
        Console.WriteLine("Attempt to override sealed method.");
    }
}

class SealedMethodDemo
{
    public static void Lab16()
    {
        FixedDepositAccount fda = new FixedDepositAccount();
        fda.AccountNumber = 12345;
        fda.CalculateInterest();

        Console.WriteLine("\nAttempting to override sealed method in SpecialFixedDepositAccount...");
    }
}
