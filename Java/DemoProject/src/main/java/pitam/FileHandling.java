package pitam;

import java.io.File;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) {
        File f = new File("C://Users/Pitam/test.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {

        }

        System.out.println("Exists = " + f.exists());

    }
}
