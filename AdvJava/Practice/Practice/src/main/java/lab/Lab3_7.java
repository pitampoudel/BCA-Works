package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Color Picker: Design Tool
public class Lab3_7 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Picker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel colorPanel = new JPanel();
        colorPanel.setBounds(50, 50, 300, 100);
        colorPanel.setBackground(Color.BLACK);

        JSlider redSlider = new JSlider(0, 255, 0);
        redSlider.setBounds(50, 170, 300, 40);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);

        JSlider greenSlider = new JSlider(0, 255, 0);
        greenSlider.setBounds(50, 220, 300, 40);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);

        JSlider blueSlider = new JSlider(0, 255, 0);
        blueSlider.setBounds(50, 270, 300, 40);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);

        Runnable updateColor = () -> {
            int r = redSlider.getValue();
            int g = greenSlider.getValue();
            int b = blueSlider.getValue();
            colorPanel.setBackground(new Color(r, g, b));
        };

        redSlider.addChangeListener(e -> updateColor.run());
        greenSlider.addChangeListener(e -> updateColor.run());
        blueSlider.addChangeListener(e -> updateColor.run());

        frame.add(colorPanel);
        frame.add(redSlider);
        frame.add(greenSlider);
        frame.add(blueSlider);
        frame.setVisible(true);
    }
}
