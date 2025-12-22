package mvc;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginPageExample {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Login Page");
        panel.add(titleLabel);

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username:"));
        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(200, 25));
        usernamePanel.add(username);
        panel.add(usernamePanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(200, 25));
        passwordPanel.add(password);
        panel.add(passwordPanel);


        DB db = new DB();
        db.connect();
        db.validateUser(username.getText(), new String(password.getPassword()));

        frame.add(panel);
        frame.setVisible(true);
    }
}
