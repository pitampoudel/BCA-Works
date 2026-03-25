package lab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2_3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IT Club Tutorial App");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Buttons
        JButton messageButton = new JButton("Message Dialog");
        messageButton.setBounds(50, 50, 130, 25);

        JButton confirmButton = new JButton("Confirmation Dialog");
        confirmButton.setBounds(50, 85, 170, 25);

        JButton inputButton = new JButton("Input Dialog");
        inputButton.setBounds(50, 120, 130, 25);

        // Button actions
        messageButton.addActionListener( e ->
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

        // Add components to frame
        frame.add(messageButton);
        frame.add(confirmButton);
        frame.add(inputButton);

        frame.setVisible(true);
    }
}
