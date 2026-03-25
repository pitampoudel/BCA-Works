package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4_4 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Traffic Light Simulator");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        // Panel to show traffic light color
        JPanel lightPanel = new JPanel();
        lightPanel.setBounds(100, 50, 100, 100);
        lightPanel.setBackground(Color.GRAY);

        // Radio buttons
        JRadioButton redButton = new JRadioButton("Red");
        redButton.setBounds(20, 170, 80, 30);
        JRadioButton yellowButton = new JRadioButton("Yellow");
        yellowButton.setBounds(100, 170, 80, 30);
        JRadioButton greenButton = new JRadioButton("Green");
        greenButton.setBounds(180, 170, 80, 30);

        // Group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        // ActionListener to change panel color
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (redButton.isSelected()) {
                    lightPanel.setBackground(Color.RED);
                } else if (yellowButton.isSelected()) {
                    lightPanel.setBackground(Color.YELLOW);
                } else if (greenButton.isSelected()) {
                    lightPanel.setBackground(Color.GREEN);
                }
            }
        };

        redButton.addActionListener(listener);
        yellowButton.addActionListener(listener);
        greenButton.addActionListener(listener);

        // Add components to frame
        frame.add(lightPanel);
        frame.add(redButton);
        frame.add(yellowButton);
        frame.add(greenButton);

        // Make frame visible
        frame.setVisible(true);
    }
}
