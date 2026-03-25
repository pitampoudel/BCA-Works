package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Dialog Demonstrator: IT Club Tutorial App.
public class Lab2_3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IT Club Tutorial App");
        frame.setSize(420, 140);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton messageButton = new JButton("Message Dialog");
        JButton confirmButton = new JButton("Confirmation Dialog");
        JButton inputButton = new JButton("Input Dialog");
        frame.setLayout(new FlowLayout());

        messageButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "This is a message dialog, thank you for clicking it!")
        );

        confirmButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame, "Do you confirm?", "Confirm", JOptionPane.YES_NO_OPTION);
            JOptionPane.showMessageDialog(frame, "You selected: " + (response == JOptionPane.YES_OPTION ? "Yes" : "No"));
        });

        inputButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter something:");
            if (input != null) {
                JOptionPane.showMessageDialog(frame, "You entered: " + input);
            }
        });

        frame.add(messageButton);
        frame.add(confirmButton);
        frame.add(inputButton);
        frame.setVisible(true);
    }
}
