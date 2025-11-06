import javax.swing.*;
import java.awt.*;

public class SwingShapesExample {
    public static class ShapesPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Draw blue rectangle
            int rectangleSize = Math.min(panelWidth, panelHeight) / 2;
            int rectangleXPosition = (panelWidth - rectangleSize) / 2;
            int rectangleYPosition = (panelHeight - rectangleSize) / 2;
            graphics.setColor(Color.WHITE);
            graphics.fillRect(rectangleXPosition, rectangleYPosition, rectangleSize, rectangleSize);

            // Draw red circle
            int circleSize = rectangleSize / 2;
            int circleXPosition = (panelWidth - circleSize) / 2;
            int circleYPosition = (panelHeight - circleSize) / 2;
            graphics.setColor(Color.RED);
            graphics.fillOval(circleXPosition, circleYPosition, circleSize, circleSize);
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