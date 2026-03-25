package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Qn. Mouse Events: Interactive Banner Area
public class Lab2_6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Interactive Banner");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JPanel bannerPanel = new JPanel();
        bannerPanel.setPreferredSize(new Dimension(350, 80));
        bannerPanel.setBackground(Color.CYAN);

        JLabel statusLabel = new JLabel("Mouse status: ");

        bannerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                statusLabel.setText("Mouse status: Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                statusLabel.setText("Mouse status: Exited");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                statusLabel.setText("Mouse status: Clicked");
            }
        });

        frame.add(bannerPanel);
        frame.add(statusLabel);
        frame.setVisible(true);
    }
}
