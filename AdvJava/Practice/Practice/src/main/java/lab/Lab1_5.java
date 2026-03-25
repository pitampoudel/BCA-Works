package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Color Button Actions: change a panel color when Red, Yellow, or Blue is clicked.
public class Lab1_5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Programs");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JButton redButton = new JButton("Red");
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 200));

        redButton.addActionListener(e -> panel.setBackground(Color.RED));
        yellowButton.addActionListener(e -> panel.setBackground(Color.YELLOW));
        blueButton.addActionListener(e -> panel.setBackground(Color.BLUE));

        frame.add(redButton);
        frame.add(yellowButton);
        frame.add(blueButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}
