package lab;

import java.io.File;

public class lab18 {

    public static void main(String[] args) {

        String path = "E:\\BCA\\3rd sem\\java";

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("The directory exists: " + path);
            } else if (file.isFile()) {
                System.out.println("The file exists: " + path);
            }
        } else {
            System.out.println("The file or directory does not exist: " + path);
        }
        System.out.println("Copyright Pitam Poudel");
    }
}
