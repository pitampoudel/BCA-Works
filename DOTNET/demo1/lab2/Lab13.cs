using System;

// Base class
class Notification
{
    public string Message { get; set; }

    public Notification(string message)
    {
        Message = message;
    }

    // Virtual method
    public virtual void Send()
    {
        Console.WriteLine("Sending notification: " + Message);
    }
}

// Derived class
class EmailNotification : Notification
{
    public EmailNotification(string message) : base(message)
    {
    }

    // Overriding the virtual method
    public override void Send()
    {
        Console.WriteLine("Sending EMAIL notification: " + Message);
    }
}

// Main program to test runtime polymorphism
class VirtualMethod
{
    public static void Lab13()
    {
        Console.WriteLine("Pitam Poudel");
        // Creating a base class object
        Notification n1 = new Notification("System update at 5 PM.");
        n1.Send();  // Calls base class method

        // Creating a derived class object
        Notification n2 = new EmailNotification("Your account has been updated.");
        n2.Send();  // Calls overridden method (runtime polymorphism)

    }
}
