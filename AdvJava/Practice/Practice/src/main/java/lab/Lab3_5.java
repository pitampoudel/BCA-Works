package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Registration Form
public class Lab3_5 extends JFrame {
    public Lab3_5() {
        setTitle("Registration Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField addressField = new JTextField();
        JButton submitBtn = new JButton("Submit");

        submitBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Data entered successfully", "Success", JOptionPane.INFORMATION_MESSAGE)
        );

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("Age:"));
        add(ageField);

        add(new JLabel("Email:"));
        add(emailField);

        add(new JLabel("Course:"));
        add(courseField);

        add(new JLabel("Address:"));
        add(addressField);

        add(new JLabel());
        add(submitBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Lab3_5();
    }
}
