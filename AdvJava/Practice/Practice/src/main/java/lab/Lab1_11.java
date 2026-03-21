import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab1_11 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Event Registration");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Display your name in the frame
        JLabel nameLabel = new JLabel("Saudeep Adhikari");
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(nameLabel);

        // Button to get user name
        JButton greetButton = new JButton("Click to Greet");
        frame.add(greetButton);

        // Button click action
        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = JOptionPane.showInputDialog(frame, "What is your name?");
                if (userName != null && !userName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Welcome, " + userName + "!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Welcome, Guest!");
                }
            }
        });

        frame.setVisible(true);
    }
}
