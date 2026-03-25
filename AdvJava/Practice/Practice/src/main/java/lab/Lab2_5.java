package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Button Click Handler: Basic Action Listener
public class Lab2_5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Click Demo");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel counterLabel = new JLabel("Button clicked: 0 time(s)");
        JButton clickButton = new JButton("Click Me");
        int[] count = {0};

        clickButton.addActionListener(e -> {
            count[0]++;
            counterLabel.setText("Button clicked: " + count[0] + " time(s)");
        });

        frame.add(counterLabel);
        frame.add(clickButton);
        frame.setVisible(true);
    }
}
