package pitam;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        int salaryPerHour = 5000;
        System.out.println("Enter day number in which you are going to take payment\n");
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();

        int total = 0;
        for (int i = 1; i <= day; i++) {
            total += (i * salaryPerHour);
        }

        System.out.println("Total payment you will receive is: "+total);

    }
}
