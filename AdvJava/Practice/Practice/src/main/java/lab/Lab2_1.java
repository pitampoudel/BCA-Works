package lab;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Lab2_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gender Selection");
        frame.setSize(300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Gender selection label
        JLabel label = new JLabel("Selected Gender:");
        label.setBounds(50, 120, 200, 20);

        // Radio buttons
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(50, 40, 70, 20);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(120, 40, 80, 20);
        JRadioButton other = new JRadioButton("Other");
        other.setBounds(210, 40, 70, 20);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        // Action listener to update selected gender
        ActionListener listener = e -> label.setText("Selected Gender: " + ((JRadioButton) e.getSource()).getText());
        male.addActionListener(listener);
        female.addActionListener(listener);
        other.addActionListener(listener);

        // Add components to frame
        frame.add(male);
        frame.add(female);
        frame.add(other);
        frame.add(label);

        frame.setVisible(true);
    }
}
