package lab;

public class lab2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command line arguments provided");
        } else {
            System.out.println("Number of command line arguments: " + args.length);
            for (int i = 0; i < args.length; i++) {
                System.out.println("Arg " + i+1 + ": " + args[i]);
            }
        }
        System.out.println("Copyright Pitam Poudel");
    }

}
