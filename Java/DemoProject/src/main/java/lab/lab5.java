package lab;
import java.util.Scanner;

public class lab5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;

        int difference = num1 - num2;

        int product = num1 * num2;

        double average = (num1 + num2) / 2.0;

        int distance = Math.abs(num1 - num2);

        int max = Math.max(num1, num2);

        int min = Math.min(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Average: " + average);
        System.out.println("Distance: " + distance);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        scanner.close();
        System.out.println("Copyright Pitam Poudel");
    }
}


	


