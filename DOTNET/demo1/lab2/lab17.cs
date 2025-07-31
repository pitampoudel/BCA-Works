using System;

// Sealed class
sealed class Utility
{
    public void ShowMessage(string message)
    {
        Console.WriteLine("Message: " + message);
    }

    public void Log(string logEntry)
    {
        Console.WriteLine("Log: " + logEntry);
    }
}

// This will cause a compile-time error
// class AdvancedUtility : Utility
// {
//     // Error: Cannot derive from sealed type 'Utility'
// }

class SealedClassDemo
{
    public static void Lab17()
    {
        Utility util = new Utility();
        util.ShowMessage("Welcome to the system!");
        util.Log("System initialized successfully.");
    }
}
