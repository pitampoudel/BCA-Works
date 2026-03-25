package lab;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Lab1_21 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Color Picker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Panel to show selected color
        JPanel colorPanel = new JPanel();
        colorPanel.setBounds(50, 50, 300, 100);
        colorPanel.setBackground(Color.BLACK);

        // Red slider
        JSlider redSlider = new JSlider(0, 255, 0);
        redSlider.setBounds(50, 170, 300, 40);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);

        // Green slider
        JSlider greenSlider = new JSlider(0, 255, 0);
        greenSlider.setBounds(50, 220, 300, 40);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);

        // Blue slider
        JSlider blueSlider = new JSlider(0, 255, 0);
        blueSlider.setBounds(50, 270, 300, 40);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);

        // ChangeListener to update color
        ChangeListener listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int r = redSlider.getValue();
                int g = greenSlider.getValue();
                int b = blueSlider.getValue();
                colorPanel.setBackground(new Color(r, g, b));
            }
        };

        redSlider.addChangeListener(listener);
        greenSlider.addChangeListener(listener);
        blueSlider.addChangeListener(listener);

        // Add components to frame
        frame.add(colorPanel);
        frame.add(redSlider);
        frame.add(greenSlider);
        frame.add(blueSlider);

        // Make frame visible
        frame.setVisible(true);
    }
}
