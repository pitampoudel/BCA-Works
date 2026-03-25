package lab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab1_9 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hobby Picker");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Hobby checkboxes
        JCheckBox reading = new JCheckBox("Reading");
        reading.setBounds(50, 40, 100, 20);
        JCheckBox sports = new JCheckBox("Sports");
        sports.setBounds(50, 70, 100, 20);
        JCheckBox music = new JCheckBox("Music");
        music.setBounds(50, 100, 100, 20);
        JCheckBox traveling = new JCheckBox("Traveling");
        traveling.setBounds(50, 130, 100, 20);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 160, 100, 25);

        // Label to display selected hobbies
        JLabel resultLabel = new JLabel("Your selected hobbies: ");
        resultLabel.setBounds(50, 190, 300, 20);

        // Button click event
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hobbies = "";
                if (reading.isSelected()) hobbies += "Reading, ";
                if (sports.isSelected()) hobbies += "Sports, ";
                if (music.isSelected()) hobbies += "Music, ";
                if (traveling.isSelected()) hobbies += "Traveling, ";

                if (!hobbies.isEmpty()) {
                    hobbies = hobbies.substring(0, hobbies.length() - 2);
                } else {
                    hobbies = "None";
                }

                resultLabel.setText("Your selected hobbies: " + hobbies);
            }
        });

        // Add components to frame
        frame.add(reading);
        frame.add(sports);
        frame.add(music);
        frame.add(traveling);
        frame.add(submitButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
