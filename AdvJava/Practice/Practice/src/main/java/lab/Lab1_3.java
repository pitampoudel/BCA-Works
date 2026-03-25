package lab;

import javax.swing.*;
import java.awt.*;

// Qn. College Dashboard Layout: arrange five labeled panels using BorderLayout.
public class Lab1_3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("College Dashboard");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.CYAN);
        homePanel.add(new JLabel("Home"));

        JPanel attendancePanel = new JPanel();
        attendancePanel.setBackground(Color.LIGHT_GRAY);
        attendancePanel.add(new JLabel("Attendance"));

        JPanel examsPanel = new JPanel();
        examsPanel.setBackground(Color.ORANGE);
        examsPanel.add(new JLabel("Exams"));

        JPanel libraryPanel = new JPanel();
        libraryPanel.setBackground(Color.GREEN);
        libraryPanel.add(new JLabel("Library"));

        JPanel feesPanel = new JPanel();
        feesPanel.setBackground(Color.PINK);
        feesPanel.add(new JLabel("Fees"));

        frame.add(homePanel, BorderLayout.NORTH);
        frame.add(attendancePanel, BorderLayout.WEST);
        frame.add(examsPanel, BorderLayout.CENTER);
        frame.add(libraryPanel, BorderLayout.EAST);
        frame.add(feesPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
