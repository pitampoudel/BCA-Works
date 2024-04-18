package pitam;

import java.util.Random;

public class MathSample {
    public static void printRandom() {
        var random = (Math.random());
        System.out.println(random);

        var rand = new Random();
        System.out.println(rand.nextDouble());
    }
    public static void main(String[] args){
        printRandom();
    }
}
