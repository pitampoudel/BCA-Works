package lab;

import javax.swing.*;
import java.awt.*;

// Qn. Scrollable Area: Notes App
public class Lab3_6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Notes App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
