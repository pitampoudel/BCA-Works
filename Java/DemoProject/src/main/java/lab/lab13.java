package lab;
public class lab13 {
    public static void main(String[] args) {
        String str = "Pitam Poudel";

        System.out.println("Length of the string: " + str.length());

        System.out.println("String in uppercase: " + str.toUpperCase());

        System.out.println("String in lowercase: " + str.toLowerCase());

        String strTrim = "Pitam Poudel";
        System.out.println("String after trimming: " + strTrim.trim());

        System.out.println("Index of 'Pitam': " + str.indexOf("Pitam"));

        System.out.println("String after replacing 'Poudel' with 'Paudel': " + str.replace("Poudel", "Paudel"));

        String str2 = "Pitam Poudel";
        System.out.println("Is 'str' equal to 'str2'? " + str.equals(str2));

        System.out.println("Substring from 7th character: " + str.substring(7));
    }
}

