import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab1_24 extends JFrame implements ActionListener {

    JTextField display;
    double firstNumber = 0;
    String operator = "";

    public Lab1_24() {

        setTitle("Calculator-- Saudeep Adhikari");
        setSize(320, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 26));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
                "7", "8", "9", "C",
                "4", "5", "6", "+",
                "1", "2", "3", "-",
                "0", "*", "%", "="
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

        // Digits
        if (input.matches("[0-9]")) {
            display.setText(display.getText() + input);
        }

        // Operators
        else if (input.matches("[+\\-*%]")) {
            try {
                firstNumber = Double.parseDouble(display.getText());
                operator = input;
                display.setText("");
            } catch (Exception ex) {
                display.setText("Error");
            }
        }

        // Equals
        else if (input.equals("=")) {
            try {
                double secondNumber = Double.parseDouble(display.getText());
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "%":
                        result = firstNumber % secondNumber;
                        break;
                }
                display.setText(String.valueOf(result));
            } catch (Exception ex) {
                display.setText("Error");
            }
        }

        // Clear
        else if (input.equals("C")) {
            display.setText("");
            firstNumber = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new Lab1_24();
    }
}
