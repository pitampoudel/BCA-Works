package graphics;

import javax.swing.*;
import java.awt.*;

public class CalculatorExample {
    private static double result = 0;
    private static String lastOperation = "=";
    private static boolean startNumber = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();

        JTextField display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setBackground(new Color(230, 230, 230));
        display.setMargin(new Insets(10, 10, 10, 10));

        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 8, 8));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        for (String label : buttonLabels) {
            JButton button = getJButton(label, display);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
    }

    private static JButton getJButton(String label, JTextField display) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        if ("+-*/".contains(label)) {
            button.setBackground(new Color(255, 159, 67));
            button.setForeground(Color.WHITE);
        } else if ("=".equals(label)) {
            button.setBackground(new Color(46, 204, 113));
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(new Color(245, 245, 245));
        }
        button.addActionListener(e -> {
            String command = e.getActionCommand();
            if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
                if (startNumber) {
                    display.setText(command);
                } else {
                    display.setText(display.getText() + command);
                }
                startNumber = false;
            } else {
                if (!startNumber) {
                    double x = Double.parseDouble(display.getText());
                    calculate(x);
                    display.setText(String.valueOf(result));
                    startNumber = true;
                }
                lastOperation = command;
            }
        });
        return button;
    }

    private static void calculate(double n) {
        switch (lastOperation) {
            case "+" -> result += n;
            case "-" -> result -= n;
            case "*" -> result *= n;
            case "/" -> result /= n;
            case "=" -> result = n;
        }
    }
}
