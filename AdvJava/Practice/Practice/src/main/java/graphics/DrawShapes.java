package graphics;

import javax.swing.*;
import java.awt.*;

public class DrawShapes extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Line
        g.drawLine(50, 50, 200, 50);

        // Draw Rectangle
        g.drawRect(50, 80, 150, 80);

        // Fill Rectangle
        g.setColor(Color.BLUE);
        g.fillRect(220, 80, 150, 80);

        // Draw Oval
        g.setColor(Color.BLACK);
        g.drawOval(50, 180, 150, 80);

        // Fill Oval
        g.setColor(Color.RED);
        g.fillOval(220, 180, 150, 80);

        // Draw Circle (oval with equal width & height)
        g.setColor(Color.GREEN);
        g.drawOval(150, 300, 80, 80);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Shapes");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new DrawShapes());
        frame.setVisible(true);
    }
}