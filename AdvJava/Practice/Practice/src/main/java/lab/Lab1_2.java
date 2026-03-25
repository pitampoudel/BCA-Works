package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Login Form UI: build a basic username-password form with a submit button.
public class Lab1_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("College Portal Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Submit");
        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Login Attempted"));

        frame.add(new JLabel("Username:"));
        frame.add(userField);
        frame.add(new JLabel("Password:"));
        frame.add(passField);
        frame.add(new JLabel());
        frame.add(loginButton);
        frame.setVisible(true);
    }
}
