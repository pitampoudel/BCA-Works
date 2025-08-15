using System;

namespace EducationalSystem
{
    // Base class
    class Person3
    {
        public string Name;

        public void ShowName()
        {
            Console.WriteLine("Name: " + Name);
        }
    }

    // Derived class - Student
    class Student : Person3
    {
        public int Grade;

        public void ShowStudentInfo()
        {
            Console.WriteLine("Student Info:");
            ShowName();
            Console.WriteLine("Grade: " + Grade);
        }
    }

    // Derived class - Teacher
    class Teacher : Person3
    {
        public string Subject;

        public void ShowTeacherInfo()
        {
            Console.WriteLine("Teacher Info:");
            ShowName();
            Console.WriteLine("Subject: " + Subject);
        }
    }

    class IsandAs
    {
        public static void Run()
        {
            Console.WriteLine("Pitam Poudel");

            // Ask user for input
            Console.Write("Enter student name: ");
            string studentName = Console.ReadLine();

            Console.Write("Enter student grade: ");
            int studentGrade = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter teacher name: ");
            string teacherName = Console.ReadLine();

            Console.Write("Enter teacher subject: ");
            string teacherSubject = Console.ReadLine();

            // Create an array of Person3 type holding both Student and Teacher objects
            Person3[] people = new Person3[2];
            people[0] = new Student { Name = studentName, Grade = studentGrade };
            people[1] = new Teacher { Name = teacherName, Subject = teacherSubject };

            foreach (Person3 person in people)
            {
                // Using is operator
                if (person is Student)
                {
                    Console.WriteLine("This person is a Student.");
                }
                else if (person is Teacher)
                {
                    Console.WriteLine("This person is a Teacher.");
                }

                // Using as operator (safe casting)
                Student student = person as Student;
                if (student != null)
                {
                    student.ShowStudentInfo();
                }

                Teacher teacher = person as Teacher;
                if (teacher != null)
                {
                    teacher.ShowTeacherInfo();
                }

                Console.WriteLine(); // For spacing
            }
        }
    }

    // Wrapper class for lab2 index 15
    class Lab2_15
    {
        public static void Run() => IsandAs.Run();
    }
}
