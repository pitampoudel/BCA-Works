package lab;

import java.awt.*;
import javax.swing.*;

// Qn. Graphics Drawing: draw circle, rectangle, ellipse, and diagonal line in a panel.
public class Lab1_6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Geometric Shapes");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int circleDiameter = 400;
                int circleX = centerX - circleDiameter / 2;
                int circleY = centerY - circleDiameter / 2;

                int rectWidth = 300;
                int rectHeight = 200;
                int rectX = centerX - rectWidth / 2;
                int rectY = centerY - rectHeight / 2;

                g2.setColor(Color.WHITE);
                g2.drawOval(circleX, circleY, circleDiameter, circleDiameter);
                g2.drawRect(rectX, rectY, rectWidth, rectHeight);
                g2.drawOval(rectX, rectY, rectWidth, rectHeight);
                g2.drawLine(rectX, rectY, rectX + rectWidth, rectY + rectHeight);
            }
        };

        panel.setBackground(Color.GRAY);
        frame.add(panel);
        frame.setVisible(true);
    }
}
