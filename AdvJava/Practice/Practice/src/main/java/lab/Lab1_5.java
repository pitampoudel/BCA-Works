package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab1_5  {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Programs");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        // Create buttons
        JButton button1 = new JButton("Red");
        JButton button2 = new JButton("Yellow");
        JButton button3 = new JButton("Blue");

        // Add buttons to frame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        // Create a panel to change its background color
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 200));
        frame.add(panel);

        // Add ActionListeners to each button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.RED);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.YELLOW);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });

        // Frame setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
