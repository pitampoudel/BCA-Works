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
            int outerShapeSize = (int) (Math.min(panelWidth, panelHeight) / 1.5);
            int outerShapeXPosition = (panelWidth - outerShapeSize) / 2;
            int outerShapeYPosition = (panelHeight - outerShapeSize) / 2;
            graphics.setColor(Color.GRAY);
            graphics.fillOval(outerShapeXPosition, outerShapeYPosition, outerShapeSize, outerShapeSize);


            // Draw rectangle
            int innerShapeSize = Math.min(panelWidth, panelHeight) / 2;
            int rectangleXPosition = (panelWidth - innerShapeSize) / 2;
            int rectangleYPosition = (panelHeight - innerShapeSize) / 2;
            graphics.setColor(Color.WHITE);
            graphics.fillRect(rectangleXPosition, rectangleYPosition, innerShapeSize, innerShapeSize);


            // Draw circle
            int circleXPosition = (panelWidth - innerShapeSize) / 2;
            int circleYPosition = (panelHeight - innerShapeSize) / 2;
            graphics.setColor(Color.lightGray);
            graphics.fillOval(circleXPosition, circleYPosition, innerShapeSize, innerShapeSize);

            // diagonal
            graphics.setColor(Color.BLACK);
            graphics.drawLine(rectangleXPosition, rectangleYPosition,
                    rectangleXPosition + innerShapeSize,
                    rectangleYPosition + innerShapeSize);
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