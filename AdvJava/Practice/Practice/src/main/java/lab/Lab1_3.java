package lab;

import javax.swing.*;
import java.awt.*;

public class Lab1_3 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("College Dashboard");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());

        JPanel homePanel = new JPanel();
        JPanel attendancePanel = new JPanel();
        JPanel examsPanel = new JPanel();
        JPanel libraryPanel = new JPanel();
        JPanel feesPanel = new JPanel();

        homePanel.setBackground(Color.CYAN);
        attendancePanel.setBackground(Color.LIGHT_GRAY);
        examsPanel.setBackground(Color.ORANGE);
        libraryPanel.setBackground(Color.GREEN);
        feesPanel.setBackground(Color.PINK);

        homePanel.add(new JLabel("Home"));
        attendancePanel.add(new JLabel("Attendance"));
        examsPanel.add(new JLabel("Exams"));
        libraryPanel.add(new JLabel("Library"));
        feesPanel.add(new JLabel("Fees"));

        frame.add(homePanel, BorderLayout.NORTH);
        frame.add(attendancePanel, BorderLayout.WEST);
        frame.add(examsPanel, BorderLayout.CENTER);
        frame.add(libraryPanel, BorderLayout.EAST);
        frame.add(feesPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

