package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Traffic Light Simulation: Road safety training app.
public class Lab4_4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Traffic Light Simulator");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel lightPanel = new JPanel();
        lightPanel.setBounds(100, 50, 100, 100);
        lightPanel.setBackground(Color.GRAY);

        JRadioButton redButton = new JRadioButton("Red");
        redButton.setBounds(20, 170, 80, 30);
        JRadioButton yellowButton = new JRadioButton("Yellow");
        yellowButton.setBounds(100, 170, 80, 30);
        JRadioButton greenButton = new JRadioButton("Green");
        greenButton.setBounds(180, 170, 80, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        Runnable updateColor = () -> {
            if (redButton.isSelected()) {
                lightPanel.setBackground(Color.RED);
            } else if (yellowButton.isSelected()) {
                lightPanel.setBackground(Color.YELLOW);
            } else if (greenButton.isSelected()) {
                lightPanel.setBackground(Color.GREEN);
            }
        };

        redButton.addActionListener(e -> updateColor.run());
        yellowButton.addActionListener(e -> updateColor.run());
        greenButton.addActionListener(e -> updateColor.run());

        frame.add(lightPanel);
        frame.add(redButton);
        frame.add(yellowButton);
        frame.add(greenButton);
        frame.setVisible(true);
    }
}
