package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3_5 extends JFrame {

    public Lab3_5() {

        setTitle("Registration Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 5×5 GridLayout
        setLayout(new GridLayout(5, 5, 5, 5));

        // Labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel courseLabel = new JLabel("Course:");
        JLabel addressLabel = new JLabel("Address:");

        // TextFields
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField addressField = new JTextField();

        // Submit Button
        JButton submitBtn = new JButton("Submit");

        // Button action
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        Lab3_5.this,
                        "Data entered successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Row 1
        add(nameLabel);
        add(nameField);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        // Row 2
        add(ageLabel);
        add(ageField);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        // Row 3
        add(emailLabel);
        add(emailField);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        // Row 4
        add(courseLabel);
        add(courseField);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        // Row 5
        add(addressLabel);
        add(addressField);
        add(submitBtn);
        add(new JLabel());
        add(new JLabel());

        setVisible(true);
    }

    public static void main(String[] args) {

        new Lab3_5();
    }
}
