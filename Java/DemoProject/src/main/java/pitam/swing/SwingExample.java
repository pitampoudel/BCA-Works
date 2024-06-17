package pitam.swing;

import javax.swing.*;

public class SwingExample extends JFrame {
    public SwingExample() {
        setBounds(500, 500, 200, 300);

        // JPanel
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Label
        JLabel lbl2 = new JLabel("Enter your email");
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


        // Button
        JButton btn = new JButton();
        btn.setBounds(5, 115, 80, 20);
        btn.setText("Login");
        btn.addActionListener(e -> {

        });
        contentPane.add(btn);
    }

    public static void main(String[] args) {
        SwingExample ex = new SwingExample();
        ex.setVisible(true);
    }
}
