package lab;

import javax.swing.*;

// Qn. Simple JFrame: create a window and show a centered welcome message.
public class Lab1_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Business Dashboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new JLabel("Welcome to Business Dashboard", SwingConstants.CENTER));
        frame.setVisible(true);
    }
}
