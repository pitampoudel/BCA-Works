package lab;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lab19 {
    public static void main(String[] args) {

        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try (FileWriter fileWriter = new FileWriter(inputFilePath)) {
            fileWriter.write("Hello I am back ");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try (FileReader fileReader = new FileReader(inputFilePath)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        // Writing to a file using FileOutputStream
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
            byte[] message = "hello".getBytes();
            fileOutputStream.write(message);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }



        // Reading from a file using FileInputStream
        try (FileInputStream fileInputStream = new FileInputStream(outputFilePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        System.out.println("\n");
        System.out.println("Copyright Pitam Poudel");
    }
}