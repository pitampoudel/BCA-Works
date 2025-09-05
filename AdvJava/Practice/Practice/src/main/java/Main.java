import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Advanced Java Features Menu ===");
            System.out.println("Please select which feature you want to run:");
            System.out.println("1. Palindrome Checker - Check if strings are palindromes");
            System.out.println("2. Fibonacci Generator - Generate Fibonacci series");
            System.out.println("3. Bubble Sort - Sort arrays using bubble sort algorithm");
            System.out.println("4. JFrame GUI Example - Display a simple GUI window");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("\n--- Running Palindrome Checker ---");
                        PalindromeChecker.main(new String[0]);
                        break;
                    case 2:
                        System.out.println("\n--- Running Fibonacci Generator ---");
                        FibonacciGenerator.main(new String[0]);
                        break;
                    case 3:
                        System.out.println("\n--- Running Bubble Sort ---");
                        BubbleSort.main(new String[0]);
                        break;
                    case 4:
                        System.out.println("\n--- Running JFrame GUI Example ---");
                        JFrameExample.main(new String[0]);
                        break;
                    case 5:
                        System.out.println("\nThank you for using Advanced Java Features!");
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("\nInvalid choice! Please enter a number between 1 and 5.");
                }

                // Ask if user wants to continue
                System.out.print("\nWould you like to run another feature? (y/n): ");
                String continueChoice = scanner.nextLine().trim().toLowerCase();
                if (!continueChoice.equals("y") && !continueChoice.equals("yes")) {
                    System.out.println("\nThank you for using Advanced Java Features!");
                    System.out.println("Goodbye!");
                    break;
                }

            } catch (Exception e) {
                System.out.println("\nInvalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }
}
