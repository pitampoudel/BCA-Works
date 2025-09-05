public class FibonacciGenerator {
    public static long[] generateFibonacci(int n) {
        if (n <= 0) return new long[0];
        long[] fib = new long[n];
        fib[0] = 0;
        if (n >= 2) fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static void main(String[] args) {
        int[] tests = {5, 10, 15};
        for (int n : tests) {
            long[] fib = generateFibonacci(n);
            System.out.print("Fibonacci(" + n + "): ");
            for (int i = 0; i < fib.length; i++) {
                System.out.print(fib[i] + (i < fib.length - 1 ? ", " : "\n"));
            }
        }
    }
}
