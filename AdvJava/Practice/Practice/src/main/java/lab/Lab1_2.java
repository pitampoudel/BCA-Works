import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab1_2{

    public static void main(String[] args) {

        JFrame frame = new JFrame("College Portal Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel("Saudeep Adhikari", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(nameLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginButton = new JButton("Submit");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Login Attempted");
            }
        });

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
