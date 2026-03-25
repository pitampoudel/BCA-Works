package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

// Qn. Image Transform: editor prototype
public class Lab3_4 extends JFrame {
    public Lab3_4() {
        setTitle("Image Transform");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImagePanel imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton rotateLeft = new JButton("Rotate Left");
        JButton rotateRight = new JButton("Rotate Right");
        JButton zoomIn = new JButton("Zoom In");
        JButton zoomOut = new JButton("Zoom Out");

        buttonPanel.add(rotateLeft);
        buttonPanel.add(rotateRight);
        buttonPanel.add(zoomIn);
        buttonPanel.add(zoomOut);

        add(buttonPanel, BorderLayout.SOUTH);

        rotateLeft.addActionListener(e -> imagePanel.rotate(-10));
        rotateRight.addActionListener(e -> imagePanel.rotate(10));
        zoomIn.addActionListener(e -> imagePanel.zoom(1.1));
        zoomOut.addActionListener(e -> imagePanel.zoom(0.9));

        setVisible(true);
    }

    static class ImagePanel extends JPanel {
        private final Image image = new ImageIcon(getClass().getResource("/images/image1.jpg")).getImage();
        private double angle = 0;
        private double zoom = 1.0;

        ImagePanel() {}

        void rotate(double deg) {
            angle += Math.toRadians(deg);
            repaint();
        }

        void zoom(double factor) {
            zoom *= factor;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int panelW = getWidth();
            int panelH = getHeight();
            int imgW = image.getWidth(this);
            int imgH = image.getHeight(this);

            double scaleX = (double) panelW / imgW; 
            double scaleY = (double) panelH / imgH;
            double baseScale = Math.min(scaleX, scaleY) * 0.6;

            AffineTransform at = new AffineTransform();
            at.translate(panelW / 2, panelH / 2);
            at.rotate(angle);
            at.scale(baseScale * zoom, baseScale * zoom);
            at.translate(-imgW / 2, -imgH / 2);

            g2.drawImage(image, at, this);
        }
    }

    public static void main(String[] args) {
        new Lab3_4();
    }
}
