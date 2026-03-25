package lab;

import javax.swing.*;
import java.awt.*;

public class Lab1_1 {

    public static void main(String[] args) {


        JFrame frame = new JFrame("Business Dashboard");

        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/images/image1.jpg");
        frame.setIconImage(icon.getImage());

        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome to Business Dashboard", JLabel.CENTER);
        frame.add(label);

        frame.setVisible(true);
    }
}
