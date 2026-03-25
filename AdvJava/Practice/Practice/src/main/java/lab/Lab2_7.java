package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Checkbox Listener
public class Lab2_7 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Notification Preferences");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JCheckBox notifyCheckBox = new JCheckBox("Enable Notifications");
        JLabel statusLabel = new JLabel("Notifications are disabled");

        notifyCheckBox.addItemListener(e -> {
            if (notifyCheckBox.isSelected()) {
                statusLabel.setText("Notifications are enabled");
            } else {
                statusLabel.setText("Notifications are disabled");
            }
        });

        frame.add(notifyCheckBox);
        frame.add(statusLabel);
        frame.setVisible(true);
    }
}
