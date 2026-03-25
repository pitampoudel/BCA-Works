package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Qn. Basic Calculator with GUI
public class Lab4_6 extends JFrame implements ActionListener {
    private final JTextField display = new JTextField();
    private double first = 0;
    private String op = "";

    public Lab4_6() {
        setTitle("Calculator");
        setSize(320, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        display.setFont(new Font("Arial", Font.BOLD, 26));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
                "7", "8", "9", "C",
                "4", "5", "6", "+",
                "1", "2", "3", "-",
                "0", "/", "*", "="
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setFocusPainted(false);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.matches("[0-9]")) {
            display.setText(display.getText() + input);
        } else if (input.matches("[+\\-*/%]")) {
            try {
                first = Double.parseDouble(display.getText());
                op = input;
                display.setText("");
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else if (input.equals("=")) {
            try {
                double second = Double.parseDouble(display.getText());
                double result = 0;

                switch (op) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "/":
                        if (second == 0) {
                            display.setText("Error");
                            return;
                        }
                        result = first / second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "%":
                        result = first % second;
                        break;
                }
                display.setText(String.valueOf(result));
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else if (input.equals("C")) {
            display.setText("");
            first = 0;
            op = "";
        }
    }

    public static void main(String[] args) {
        new Lab4_6();
    }
}
