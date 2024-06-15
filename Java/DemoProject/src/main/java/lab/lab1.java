package lab;

import java.util.Scanner;

public class lab1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number:");
        int x = sc.nextInt();

        System.out.print("Enter the second number:");
        int y = sc.nextInt();

        System.out.print("Enter the third number:");
        int z = sc.nextInt();

        if (x > y && x > z)
            System.out.println("Largest number is:" + x);
        else if (y > z)
            System.out.println("Largest number is:" + y);
        else
            System.out.println("Largest number is:" + z);

        System.out.println("Copyright Pitam Poudel");
    }
}

