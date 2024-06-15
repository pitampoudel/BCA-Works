package lab;
public class lab12 {
    public static void main(String[] args) {
        int num = 10;
        int den = 0;

        try {
            int result = divide(num, den);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: Cannot divide by zero.");
            System.out.println("Exception Message: " + e.getMessage());
        }

        System.out.println("Program continues...");
        System.out.println("Copyright Pitam Poudel");
    }

    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }
}


