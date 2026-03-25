package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Qn. Gender Selection: Registration Form Component
public class Lab2_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gender Selection");
        frame.setSize(320, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");

        JLabel label = new JLabel("Selected Gender:");
        JPanel options = new JPanel(new FlowLayout());

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        ActionListener listener = e -> label.setText("Selected Gender: " + ((JRadioButton) e.getSource()).getText());
        male.addActionListener(listener);
        female.addActionListener(listener);
        other.addActionListener(listener);

        options.add(male);
        options.add(female);
        options.add(other);

        frame.add(options, BorderLayout.CENTER);
        frame.add(label, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
