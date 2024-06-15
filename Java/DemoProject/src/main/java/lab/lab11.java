package lab;
public class lab11 {
    private String name;
    private int accountNumber;
    private String accountType;
    private double balance;

    public lab11(String name, int accountNumber, String accountType, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". Current balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Current balance: $" + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }

    public static void main(String[] args) {
        lab11 account = new lab11("Pitam Poudel", 1234567, "Savings", 100000);

        account.deposit(5000);

        account.withdraw(200);

        account.withdraw(100);

        account.display();
    }
}
