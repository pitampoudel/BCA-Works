using System;

// Abstract class
abstract class Payment
{
    protected decimal amount;

    public Payment(decimal amount)
    {
        this.amount = amount;
    }

    // Abstract method
    public abstract void ProcessPayment();
}

// Derived class: Credit Card payment
class CreditCardPayment : Payment
{
    public CreditCardPayment(decimal amount) : base(amount) { }

    public override void ProcessPayment()
    {
        Console.WriteLine($"Processing credit card payment of Rs. {amount}...");
        Console.WriteLine("Credit card validated. Payment successful.");
    }
}

// Derived class: PayPal payment
class PayPalPayment : Payment
{
    public PayPalPayment(decimal amount) : base(amount) { }

    public override void ProcessPayment()
    {
        Console.WriteLine($"Processing PayPal payment of Rs. {amount}...");
        Console.WriteLine("PayPal account verified. Payment successful.");
    }
}

// Derived class: Bank Transfer payment
class BankTransferPayment : Payment
{
    public BankTransferPayment(decimal amount) : base(amount) { }

    public override void ProcessPayment()
    {
        Console.WriteLine($"Processing bank transfer of Rs. {amount}...");
        Console.WriteLine("Bank details confirmed. Transfer successful.");
    }
}

class Abstractclass
{
    public static void Lab5()
    {
        Console.WriteLine("Pitam Poudel");
        Console.WriteLine("Enter payment amount (Rs.):");
        decimal amount = Convert.ToDecimal(Console.ReadLine());

        Console.WriteLine("Select payment method:");
        Console.WriteLine("1. Credit Card");
        Console.WriteLine("2. PayPal");
        Console.WriteLine("3. Bank Transfer");

        Console.Write("Enter choice (1-3): ");
        int choice = Convert.ToInt32(Console.ReadLine());

        Payment payment = null;

        switch (choice)
        {
            case 1:
                payment = new CreditCardPayment(amount);
                break;
            case 2:
                payment = new PayPalPayment(amount);
                break;
            case 3:
                payment = new BankTransferPayment(amount);
                break;
            default:
                Console.WriteLine("Invalid choice. Exiting program.");
                return;
        }

        Console.WriteLine("\n--- Payment Processing ---");
        payment.ProcessPayment();

        Console.ReadLine();
    }
}
