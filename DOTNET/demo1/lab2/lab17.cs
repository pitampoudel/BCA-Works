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
    public static void Run()
    {
        Utility util = new Utility();
        util.ShowMessage("Welcome to the system!");
        util.Log("System initialized successfully.");
    }
}

// Wrapper class for lab2 index 17
class Lab2_17
{
    public static void Run() => SealedClassDemo.Run();
}
