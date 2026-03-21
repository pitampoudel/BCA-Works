import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab1_4 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Setup Wizard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Saudeep Adhikari", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(nameLabel, BorderLayout.NORTH);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        JPanel step1 = new JPanel();
        step1.add(new JLabel("Step 1: Welcome"));

        JPanel step2 = new JPanel();
        step2.add(new JLabel("Step 2: Configuration"));

        JPanel step3 = new JPanel();
        step3.add(new JLabel("Step 3: Finish"));

        cardPanel.add(step1, "1");
        cardPanel.add(step2, "2");
        cardPanel.add(step3, "3");

        JButton backButton = new JButton("Back");
        JButton nextButton = new JButton("Next");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        backButton.addActionListener(e -> cardLayout.previous(cardPanel));
        nextButton.addActionListener(e -> cardLayout.next(cardPanel));

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

