package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2_4 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Event Registration");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Button to get user name
        JButton greetButton = new JButton("Click to Greet");
        frame.add(greetButton);

        // Button click action
        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = JOptionPane.showInputDialog(frame, "What is your name?");
                if (userName != null && !userName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Welcome, " + userName + "!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Welcome, Guest!");
                }
            }
        });

        frame.setVisible(true);
    }
}
