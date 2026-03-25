package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Font Style Toggle: apply bold and italic styles to a label using checkboxes.
public class Lab1_7 extends JFrame {
    private static final int FONT_SIZE = 40;
    private final JLabel label;
    private final JCheckBox bold;
    private final JCheckBox italic;

    public Lab1_7() {
        label = new JLabel("hi there .........", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        bold = new JCheckBox("Bold", true);
        italic = new JCheckBox("Italic");

        bold.addActionListener(e -> updateFont());
        italic.addActionListener(e -> updateFont());

        JPanel panel = new JPanel();
        panel.add(bold);
        panel.add(italic);
        add(panel, BorderLayout.SOUTH);
        updateFont();
    }

    private void updateFont() {
        int style = Font.PLAIN;
        if (bold.isSelected()) {
            style += Font.BOLD;
        }
        if (italic.isSelected()) {
            style += Font.ITALIC;
        }
        label.setFont(new Font("Serif", style, FONT_SIZE));
    }

    public static void main(String[] args) {
        JFrame frame = new Lab1_7();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
