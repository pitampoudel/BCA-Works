package lab;
import java.util.Scanner;

class AreaCalculation {
    double length;
    double breadth;
    double radius;

    AreaCalculation(double l, double b) {
        length = l;
        breadth = b;
    }

    double getArea() {
        return length * breadth;
    }

    double getArea(double r) {
        radius = r;
        return Math.PI * radius * radius;
    }
}

public class lab8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter breadth of rectangle: ");
        double breadth = scanner.nextDouble();

        AreaCalculation rectangle = new AreaCalculation(length, breadth);
        System.out.println("Area of rectangle: " + rectangle.getArea());

        System.out.print("Enter radius of circle: ");
        double radius = scanner.nextDouble();

        AreaCalculation circle = new AreaCalculation(0, 0);
        System.out.println("Area of circle: " + circle.getArea(radius));

        scanner.close();
        System.out.println("Copyright Pitam Poudel");
    }
}
