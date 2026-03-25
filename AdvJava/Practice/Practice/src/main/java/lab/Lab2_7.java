package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Lab2_7{
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Notification Preferences");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Checkbox for notifications
        JCheckBox notifyCheckBox = new JCheckBox("Enable Notifications");
        frame.add(notifyCheckBox);

        // Label to show status
        JLabel statusLabel = new JLabel("Notifications are disabled");
        frame.add(statusLabel);

        // ItemListener for checkbox
        notifyCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (notifyCheckBox.isSelected()) {
                    statusLabel.setText("Notifications are enabled");
                } else {
                    statusLabel.setText("Notifications are disabled");
                }
            }
        });

        frame.setVisible(true);
    }
}
