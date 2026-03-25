package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class Lab3_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Theme Wallpaper Changer");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Image resource paths inside src/images/
        String[] images = {
                "/images/image1.jpg",
                "/images/image2.jpg",
                "/images/image3.jpg"
        };

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        final int[] index = {0};

        // Function to update image
        Runnable updateImage = () -> {
            // Use this class to load resources (ImageSwitcher was not defined)
            URL url = Lab3_2.class.getResource(images[index[0]]);
            if (url == null) {
                // resource not found - show text and clear icon to avoid NPE
                imageLabel.setText("Image not found: " + images[index[0]]);
                imageLabel.setIcon(null);
                return;
            }
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
            imageLabel.setText(null);
        };

        updateImage.run();

        // Button actions
        prevButton.addActionListener((ActionEvent e) -> {
            index[0] = (index[0] - 1 + images.length) % images.length;
            updateImage.run();
        });

        nextButton.addActionListener((ActionEvent e) -> {
            index[0] = (index[0] + 1) % images.length;
            updateImage.run();
        });

        frame.setVisible(true);
    }
}
