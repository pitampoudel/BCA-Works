package lab;

import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number of minutes: ");
        double minutes = sc.nextDouble();

        double minutesInYear = 60 * 24 * 365;
        long years = (long) (minutes / minutesInYear);
        int days = (int) (minutes / 60 / 24) % 365;

        System.out.println((int) minutes + " minutes is approximately " + years + " years and " + days + " days");
        sc.close();
    }
}
