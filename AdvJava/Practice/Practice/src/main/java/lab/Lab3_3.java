package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Qn. Click to Switch Photo
public class Lab3_3 extends JFrame {
    private final JLabel imageLabel = new JLabel("", SwingConstants.CENTER);
    private final String[] images = {
            "/images/image1.jpg",
            "/images/image2.jpg",
            "/images/image3.jpg"
    };
    private int index = 0;

    public Lab3_3() {
        setTitle("Photo Viewer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        loadImage();

        JPanel panel = new JPanel();
        panel.add(imageLabel);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index = (index + 1) % images.length;
                loadImage();
            }
        });

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void loadImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(images[index]));
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
    }

    public static void main(String[] args) {
        new Lab3_3();
    }
}
