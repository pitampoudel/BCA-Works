using System;

class Employees
{
    public string Name { get; set; }
    public int Id { get; set; }

    public Employees(string name, int id)
    {
        Name = name;
        Id = id;
    }

    public virtual double CalculateSalary()
    {
        return 0;
    }

    public void DisplayInfo()
    {
        Console.WriteLine($"ID: {Id}, Name: {Name}, Salary: ${CalculateSalary():F2}");
    }
}

class FullTimeEmployee : Employees
{
    public double MonthlySalary { get; set; }

    public FullTimeEmployee(string name, int id, double monthlySalary)
        : base(name, id)
    {
        MonthlySalary = monthlySalary;
    }

    public override double CalculateSalary()
    {
        return MonthlySalary;
    }
}

class PartTimeEmployee : Employees
{
    public double HourlyRate { get; set; }
    public int HoursWorked { get; set; }

    public PartTimeEmployee(string name, int id, double hourlyRate, int hoursWorked)
        : base(name, id)
    {
        HourlyRate = hourlyRate;
        HoursWorked = hoursWorked;
    }

    public override double CalculateSalary()
    {
        return HourlyRate * HoursWorked;
    }
}

class Intern : Employees
{
    public double Salary { get; set; }

    public Intern(string name, int id, double salary)
        : base(name, id)
    {
        Salary = salary;
    }

    public override double CalculateSalary()
    {
        return Salary;
    }
}

class MethodOverriding
{
    public static void Lab11()
    {
        Console.WriteLine("Pitam Poudel");
        
        Employees[] employees = new Employees[3];

        Console.WriteLine("Enter Full-Time Employee details:");
        Console.Write("Name: ");
        string ftName = Console.ReadLine();
        Console.Write("ID: ");
        int ftId = Convert.ToInt32(Console.ReadLine());
        Console.Write("Monthly Salary: ");
        double ftSalary = Convert.ToDouble(Console.ReadLine());
        employees[0] = new FullTimeEmployee(ftName, ftId, ftSalary);
        Console.WriteLine();

        Console.WriteLine("Enter Part-Time Employee details:");
        Console.Write("Name: ");
        string ptName = Console.ReadLine();
        Console.Write("ID: ");
        int ptId = Convert.ToInt32(Console.ReadLine());
        Console.Write("Hourly Rate: ");
        double ptRate = Convert.ToDouble(Console.ReadLine());
        Console.Write("Hours Worked: ");
        int ptHours = Convert.ToInt32(Console.ReadLine());
        employees[1] = new PartTimeEmployee(ptName, ptId, ptRate, ptHours);
        Console.WriteLine();

        Console.WriteLine("Enter Intern details:");
        Console.Write("Name: ");
        string intName = Console.ReadLine();
        Console.Write("ID: ");
        int intId = Convert.ToInt32(Console.ReadLine());
        Console.Write("Salary: ");
        double intSalary = Convert.ToDouble(Console.ReadLine());
        employees[2] = new Intern(intName, intId, intSalary);
        Console.WriteLine();

        Console.WriteLine("--- Employee Salaries ---");
        foreach (var emp in employees)
        {
            emp.DisplayInfo();
        }

        Console.ReadLine();
    }
}
