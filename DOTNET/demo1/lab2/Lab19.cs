using System;

namespace EmployeeManagementSystem
{
    // Base class
    class Employee
    {
        public string Name { get; set; }

        public virtual void Work()
        {
            Console.WriteLine($"{Name} is working.");
        }
    }

    // Derived class - Manager
    class Manager : Employee
    {
        public override void Work()
        {
            Console.WriteLine($"{Name} is managing the team.");
        }
    }

    // Derived class - Developer
    class Developer : Employee
    {
        public override void Work()
        {
            Console.WriteLine($"{Name} is writing code.");
        }
    }

    class TypepfGetType
    {
        public static void Run()
        {
            Console.WriteLine("Employee Management System");
            Console.WriteLine("Developed by Pitam Poudel\n");

            // Create employee objects

            Employee emp1 = new Manager { Name = "Ram" };
            Employee emp2 = new Developer { Name = "Gita" };

            // Store in array
            Employee[] employees = { emp1, emp2 };

            Console.WriteLine("Employee Role Report:\n");

            foreach (Employee emp in employees)
            {
                string role = emp is Manager ? "Manager" :
                              emp is Developer ? "Developer" : "Employee";

                Console.WriteLine($"Name: {emp.Name}");
                Console.WriteLine($"Role: {role}");
                Console.Write("Task: ");
                emp.Work();
                Console.WriteLine(new string('-', 30));
            }
        }
    }

    // Wrapper class for lab2 index 19
    class Lab2_19
    {
        public static void Run() => TypepfGetType.Run();
    }
}
