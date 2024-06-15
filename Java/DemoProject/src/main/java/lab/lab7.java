package lab;

import java.util.Scanner;

public class lab7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = scanner.nextInt();
        long fact = 1;

        // Check if the input is a positive integer
        if (num < 0) {
            System.out.println("Error! Factorial of a negative number doesn't exist.");
        } else {
            // Calculate the factorial using a for loop
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }

            System.out.println("Factorial of " + num + " = " + fact);
        }

        scanner.close();
        System.out.println("Copyright Pitam Poudel");
    }
}
