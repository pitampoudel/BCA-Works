package pitam;

import java.util.Scanner;

public class Calculator {
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number\n");
        int a = sc.nextInt();
        System.out.println("Enter second number\n");
        int b = sc.nextInt();
        System.out.println("Enter operator (+,-,/ or *)\n");
        String op = sc.next();

        switch (op) {
            case "+":
                a = a + b;
                break;
            case "-":
                a = a - b;
                break;
            case "*":
                a = a * b;
                break;
            case "/":
                a = a / b;
                break;
        }
        System.out.println("The result is " + a);
        sc.close();
    }
}
