package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Hobby Picker: Preference Collection Tool
public class Lab2_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hobby Picker");
        frame.setSize(360, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JCheckBox reading = new JCheckBox("Reading");
        JCheckBox sports = new JCheckBox("Sports");
        JCheckBox music = new JCheckBox("Music");
        JCheckBox traveling = new JCheckBox("Traveling");

        JButton submitButton = new JButton("Submit");
        JLabel resultLabel = new JLabel("Your selected hobbies: ");
        JPanel center = new JPanel(new GridLayout(5, 1));
        center.add(reading);
        center.add(sports);
        center.add(music);
        center.add(traveling);
        center.add(submitButton);

        submitButton.addActionListener(e -> {
            StringBuilder hobbies = new StringBuilder();
            if (reading.isSelected()) hobbies.append("Reading, ");
            if (sports.isSelected()) hobbies.append("Sports, ");
            if (music.isSelected()) hobbies.append("Music, ");
            if (traveling.isSelected()) hobbies.append("Traveling, ");

            if (hobbies.length() >= 2) {
                hobbies.setLength(hobbies.length() - 2);
            } else {
                hobbies.append("None");
            }

            resultLabel.setText("Your selected hobbies: " + hobbies);
        });

        frame.add(center, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
