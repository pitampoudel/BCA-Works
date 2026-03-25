package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab1_17 extends JFrame {

    JLabel imageLabel;
    String[] images = {
            "/images/image1.jpg",
            "/images/image2.jpg",
            "/images/image3.jpg"
    };
    int index = 0;

    public Lab1_17() {

        setTitle("Photo Viewer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadImage();

        JPanel panel = new JPanel();
        panel.add(imageLabel);

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                index = (index + 1) % images.length;
                loadImage();
            }
        });

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    void loadImage() {
        ImageIcon icon = new ImageIcon(
                getClass().getResource(images[index])
        );
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
    }

    public static void main(String[] args) {

        new Lab1_17();
    }
}
