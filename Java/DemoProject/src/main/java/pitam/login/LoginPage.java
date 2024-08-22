package pitam.login;

import javax.swing.*;

public class LoginPage extends JFrame {
    UsersData usersData = new UsersData();

    public LoginPage() {
        setBounds(500, 500, 200, 300);

        // JPanel
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);

        // Label
        JLabel lbl2 = new JLabel("Enter your username");
        lbl2.setBounds(5, 5, 574, 14);
        contentPane.add(lbl2);

        // Text Field
        JTextField nameField = new JTextField();
        nameField.setBounds(5, 25, 100, 30);
        contentPane.add(nameField);

        // Label
        JLabel lbl3 = new JLabel("Password");
        lbl3.setBounds(5, 60, 574, 14);
        contentPane.add(lbl3);

        // Text Field
        JTextField pwdField = new JTextField();
        pwdField.setBounds(5, 80, 100, 30);
        contentPane.add(pwdField);


        // Result
        JLabel lbl4 = new JLabel("Not logged in");
        lbl4.setBounds(5, 120, 574, 14);
        contentPane.add(lbl4);


        // Button
        JButton btn = new JButton();
        btn.setBounds(5, 145, 80, 20);
        btn.setText("Login");
        btn.addActionListener(e -> {
            if (usersData.isValidUser(nameField.getText(), pwdField.getText())) {
                lbl4.setText("You are logged in");
            }
        });
        contentPane.add(btn);


    }

    public static void main(String[] args) {
        LoginPage ex = new LoginPage();
        ex.setVisible(true);
    }
}
