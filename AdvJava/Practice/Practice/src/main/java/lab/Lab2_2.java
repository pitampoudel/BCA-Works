package lab;

import javax.swing.*;
// Qn. Hobby Picker: Preference Collection Tool
public class Lab2_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hobby Picker");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JCheckBox reading = new JCheckBox("Reading");
        reading.setBounds(50, 40, 100, 20);
        JCheckBox sports = new JCheckBox("Sports");
        sports.setBounds(50, 70, 100, 20);
        JCheckBox music = new JCheckBox("Music");
        music.setBounds(50, 100, 100, 20);
        JCheckBox traveling = new JCheckBox("Traveling");
        traveling.setBounds(50, 130, 100, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 160, 100, 25);

        JLabel resultLabel = new JLabel("Your selected hobbies: ");
        resultLabel.setBounds(50, 190, 300, 20);

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

        frame.add(reading);
        frame.add(sports);
        frame.add(music);
        frame.add(traveling);
        frame.add(submitButton);
        frame.add(resultLabel);
        frame.setVisible(true);
    }
}
