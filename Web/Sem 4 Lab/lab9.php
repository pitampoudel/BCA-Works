<?php
// LAB 9: Implementing a Class in PHP
echo "<h2>LAB 9: Implementing a Class in PHP</h2>";

class Student
{
    private $name, $age, $grade;

    // Constructor
    public function __construct($name, $age, $grade)
    {
        $this->name = $name;
        $this->age = $age;
        $this->grade = $grade;
    }

    // Method to display student details
    public function displayDetails()
    {
        return "Student Name: $this->name, Age: $this->age, Grade: $this->grade<br>";
    }
}

// Display header
echo "<strong>Student Details:</strong><br>";
echo str_repeat("=", 20) . "<br>";

// Create and display student objects
$students = [
    new Student("Saudeep Adhikari", 21, "A+"),
    new Student("Roshan Tamang", 20, "A"),
    new Student("Jeshan Khatri", 19, "A"),
];

foreach ($students as $student) {
    echo $student->displayDetails();
}

// Display copyright
echo "<br>© 2025 Pitam. All rights reserved.";
