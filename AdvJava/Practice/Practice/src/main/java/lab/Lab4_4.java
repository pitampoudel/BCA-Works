package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Traffic Light Simulation: Road safety training app.
public class Lab4_4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Traffic Light Simulator");
        frame.setSize(320, 260);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel lightPanel = new JPanel();
        lightPanel.setPreferredSize(new Dimension(100, 100));
        lightPanel.setBackground(Color.GRAY);

        JRadioButton redButton = new JRadioButton("Red");
        JRadioButton yellowButton = new JRadioButton("Yellow");
        JRadioButton greenButton = new JRadioButton("Green");
        JPanel buttons = new JPanel(new FlowLayout());

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

        buttons.add(redButton);
        buttons.add(yellowButton);
        buttons.add(greenButton);

        frame.add(lightPanel, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
