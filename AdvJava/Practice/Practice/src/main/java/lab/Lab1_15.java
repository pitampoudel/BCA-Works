package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab1_15 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fun Drawing Tool");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel to draw smiley
        SmileyPanel smileyPanel = new SmileyPanel();
        frame.add(smileyPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

// Custom panel class
class SmileyPanel extends JPanel {
    private int x = -100, y = -100; // Initial position off-screen

    public SmileyPanel() {
        setBackground(Color.CYAN);

        // Draw smiley at mouse click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Only draw if coordinates are set
        if (x >= 0 && y >= 0) {
            // Face
            g.setColor(Color.YELLOW);
            g.fillOval(x - 50, y - 50, 100, 100);

            // Eyes
            g.setColor(Color.BLACK);
            g.fillOval(x - 25, y - 20, 15, 15);
            g.fillOval(x + 10, y - 20, 15, 15);

            // Mouth
            g.drawArc(x - 25, y, 50, 25, 0, -180);
        }
    }
}
