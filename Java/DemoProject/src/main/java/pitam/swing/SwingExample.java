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
        JLabel lbl1 = new JLabel("Hello!");
        lbl1.setBounds(5, 5, 574, 14);
        // lbl1.setBorder(BorderFactory.cre(Color.BLUE));
        contentPane.add(lbl1);

        // Label
        JLabel lbl2 = new JLabel("Enter your name");
        lbl2.setBounds(5, 20, 574, 14);
        contentPane.add(lbl2);

        // Text Field
        JTextField nameField = new JTextField();
        nameField.setBounds(5,40,100,30);
        contentPane.add(nameField);

        // Button
        JButton btn = new JButton();
        btn.setBounds(5,75,80,20);
        btn.setText("Next");
        btn.addActionListener(e -> lbl1.setText("Welcome "+nameField.getText()+"!"));
        contentPane.add(btn);
    }

    public static void main(String[] args) {
        SwingExample ex = new SwingExample();
        ex.setVisible(true);
    }
}
