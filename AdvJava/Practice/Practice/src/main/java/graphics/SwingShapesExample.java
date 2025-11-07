package graphics;

import javax.swing.*;
import java.awt.*;

public class SwingShapesExample {
    public static class ShapesPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Draw circle
            int outerShapeSize = Math.min(panelWidth, panelHeight) / 2;
            int outerShapeXPosition = (panelWidth - outerShapeSize) / 2;
            int outerShapeYPosition = (panelHeight - outerShapeSize) / 2;
            graphics.setColor(Color.GRAY);
            graphics.fillOval(outerShapeXPosition, outerShapeYPosition, outerShapeSize, outerShapeSize);


            // Draw rectangle
            int innerShapeSize = (int) (outerShapeSize / Math.sqrt(2));
            int innerShapeXPosition = outerShapeXPosition + (outerShapeSize - innerShapeSize) / 2;
            int innerShapeYPosition = outerShapeYPosition + (outerShapeSize - innerShapeSize) / 2;
            graphics.setColor(Color.WHITE);
            graphics.fillRect(innerShapeXPosition, innerShapeYPosition, innerShapeSize, innerShapeSize);

            // Draw circle
            graphics.setColor(Color.lightGray);
            graphics.fillOval(innerShapeXPosition, innerShapeYPosition, innerShapeSize, innerShapeSize);

            // diagonal
            graphics.setColor(Color.BLACK);
            graphics.drawLine(innerShapeXPosition, innerShapeYPosition,
                    innerShapeXPosition + innerShapeSize,
                    innerShapeYPosition + innerShapeSize);
        }
    }


    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Shapes GUI Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(new ShapesPanel());
        mainFrame.setVisible(true);
    }
}