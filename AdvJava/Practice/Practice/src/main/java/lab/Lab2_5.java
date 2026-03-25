package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2_5 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Button Click Demo");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Label to show counter
        JLabel counterLabel = new JLabel("Button clicked: 0 time(s)");
        frame.add(counterLabel);

        // Button to click
        JButton clickButton = new JButton("Click Me");
        frame.add(clickButton);

        // Counter variable
        final int[] count = {0};

        // Button click action
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count[0]++;
                counterLabel.setText("Button clicked: " + count[0] + " time(s)");
            }
        });

        frame.setVisible(true);
    }
}
