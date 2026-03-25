package lab;

import javax.swing.*;
import java.awt.*;
// Qn. Greeting Dialog: Event Registration
public class Lab2_4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Registration");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton greetButton = new JButton("Click to Greet");

        greetButton.addActionListener(e -> {
            String userName = JOptionPane.showInputDialog(frame, "What is your name?");
            if (userName != null && !userName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Welcome, " + userName + "!");
            } else {
                JOptionPane.showMessageDialog(frame, "Welcome, Guest!");
            }
        });

        frame.add(greetButton);
        frame.setVisible(true);
    }
}
