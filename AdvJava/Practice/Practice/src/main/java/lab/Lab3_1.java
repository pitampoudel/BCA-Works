package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Qn. Smiley Face: Fun drawing tool
public class Lab3_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fun Drawing Tool");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SmileyPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

class SmileyPanel extends JPanel {
    private int x = -100;
    private int y = -100;

    public SmileyPanel() {
        setBackground(Color.CYAN);
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
        if (x >= 0 && y >= 0) {
            g.setColor(Color.YELLOW);
            g.fillOval(x - 25, y - 20, 15, 15);
            g.fillOval(x + 10, y - 20, 15, 15);
            g.drawArc(x - 25, y, 50, 25, 0, -180);
        }
    }
}
