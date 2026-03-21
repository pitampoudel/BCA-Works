import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab1_13 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Interactive Banner");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Display your name in the frame
        JLabel nameLabel = new JLabel("Saudeep Adhikari");
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(nameLabel);

        // Panel for mouse events
        JPanel bannerPanel = new JPanel();
        bannerPanel.setPreferredSize(new Dimension(350, 80));
        bannerPanel.setBackground(Color.CYAN);
        frame.add(bannerPanel);

        // Status label
        JLabel statusLabel = new JLabel("Mouse status: ");
        frame.add(statusLabel);

        // Mouse events
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

        frame.setVisible(true);
    }
}
