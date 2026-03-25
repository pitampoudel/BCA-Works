package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Color Picker: Design Tool
public class Lab3_7 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Picker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
        colorPanel.setPreferredSize(new Dimension(300, 120));

        JSlider redSlider = new JSlider(0, 255, 0);
        JSlider greenSlider = new JSlider(0, 255, 0);
        JSlider blueSlider = new JSlider(0, 255, 0);
        for (JSlider s : new JSlider[]{redSlider, greenSlider, blueSlider}) {
            s.setPaintTicks(true);
            s.setPaintLabels(true);
        }

        Runnable updateColor = () -> {
            int r = redSlider.getValue();
            int g = greenSlider.getValue();
            int b = blueSlider.getValue();
            colorPanel.setBackground(new Color(r, g, b));
        };

        redSlider.addChangeListener(e -> updateColor.run());
        greenSlider.addChangeListener(e -> updateColor.run());
        blueSlider.addChangeListener(e -> updateColor.run());

        JPanel sliders = new JPanel(new GridLayout(3, 1));
        sliders.add(redSlider);
        sliders.add(greenSlider);
        sliders.add(blueSlider);

        frame.add(colorPanel, BorderLayout.NORTH);
        frame.add(sliders, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
