package lab;

public class lab6 {

    public static void main(String[] args) {
        int count = 0;
        int num = 2;
        int sum = 0;
        while (count < 20) {
            if (isPrime(num)) {
                sum += num;
                count++;
            }
            num++;
        }

        System.out.println("The sum of the first 20 prime numbers is: " + sum);
        System.out.println("Copyright Pitam Poudel");
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

