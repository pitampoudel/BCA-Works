using System;
// Define an enum for task status
enum TaskStatus
{
    Pending,
    InProgress,
    Completed,
    OnHold
}

// Define the Task class
class Task
{
    public string Title { get; set; }
    public TaskStatus Status { get; set; }

    // Method to display task status
    public void DisplayStatus()
    {
        Console.WriteLine($"Task: {Title}");
        Console.WriteLine($"Status: {Status}");
        Console.WriteLine(new string('-', 30));
    }
}

class EnumDemo
{
    public static void Lab22()
    {
        Console.WriteLine("Task Management System - Demonstrating Enum");
        Console.WriteLine("By Pitam Poudel\n");

        // Create Task objects with different statuses
        Task task1 = new Task { Title = "Design UI", Status = TaskStatus.Pending };
        Task task2 = new Task { Title = "Develop Backend", Status = TaskStatus.InProgress };
        Task task3 = new Task { Title = "Write Documentation", Status = TaskStatus.OnHold };
        Task task4 = new Task { Title = "Final Testing", Status = TaskStatus.Completed };

        // Display each task's status
        task1.DisplayStatus();
        task2.DisplayStatus();
        task3.DisplayStatus();
        task4.DisplayStatus();
    }
}

