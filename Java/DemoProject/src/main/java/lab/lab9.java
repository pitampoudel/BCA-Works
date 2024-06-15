package lab;

import java.util.Scanner;

interface Shape {
    Double getArea();
}

abstract class Room implements Shape {
    Double length;
    double breadth;

    // Constructor to initialize length and breadth
    Room(Double l, double b) {
        length = l;
        breadth = b;
    }

    // Abstract method to calculate area
    @Override
    public abstract Double getArea();
}

class Bedroom extends Room {
    // Constructor to call superclass constructor
    Bedroom(double l, double b) {
        super(l, b);
    }

    // Method to calculate area of bedroom
    @Override
    public Double getArea() {
        return length * breadth;
    }
}

class DiningRoom extends Room {
    double height;

    // Constructor to initialize length, breadth and height
    DiningRoom(double b, double h) {
        super(null, b);
        height = h;
    }

    // Method to calculate area of dining room
    @Override
    public Double getArea() {
        return 0.5 * breadth * height;
    }
}

public class lab9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of bedroom: ");
        double bedroomLength = scanner.nextDouble();

        System.out.print("Enter breadth of bedroom: ");
        double bedroomBreadth = scanner.nextDouble();

        System.out.print("Enter one perpendicular side of dining room: ");
        double diningRoomBreadth = scanner.nextDouble();

        System.out.print("Enter next perpendicular side of dining room: ");
        double diningRoomHeight = scanner.nextDouble();

        Bedroom bedroom = new Bedroom(bedroomLength, bedroomBreadth);
        System.out.println("Area of bedroom: " + bedroom.getArea());

        DiningRoom diningRoom = new DiningRoom(diningRoomBreadth, diningRoomHeight);
        System.out.println("Area of dining room: " + diningRoom.getArea());

        scanner.close();
        System.out.println("Copyright Pitam Poudel");
    }
}

