import java.awt.*;
import javax.swing.*;

public class Lab1_6 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Drawing Geometric Shapes");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nameLabel = new JLabel("Saudeep Adhikari", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(nameLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                int width = getWidth();
                int height = getHeight();

                // Center coordinates
                int centerX = width / 2;
                int centerY = height / 2;

                // Outer circle
                int circleDiameter = 400;
                int circleX = centerX - circleDiameter / 2;
                int circleY = centerY - circleDiameter / 2;
                g2.setColor(Color.white);
                g2.drawOval(circleX, circleY, circleDiameter, circleDiameter);

                // Rectangle inside circle
                int rectWidth = 300;
                int rectHeight = 200;
                int rectX = centerX - rectWidth / 2;
                int rectY = centerY - rectHeight / 2;
                g2.setColor(Color.WHITE);
                g2.drawRect(rectX, rectY, rectWidth, rectHeight);

                // Oval inside rectangle
                g2.setColor(Color.WHITE);
                g2.drawOval(rectX, rectY, rectWidth, rectHeight);

                // One diagonal
                g2.setColor(Color.WHITE);
                g2.drawLine(rectX, rectY, rectX + rectWidth, rectY + rectHeight);
            }
        };

        panel.setBackground(Color.GRAY);
        frame.add(panel);
        frame.setVisible(true);
    }
}
