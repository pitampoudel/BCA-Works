package lab;

import javax.swing.*;

public class Lab1_20 {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Notes App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true); // wrap lines
        textArea.setWrapStyleWord(true);

        // Add JTextArea inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 50, 350, 200); // position and size


        // Add components to frame
        frame.add(scrollPane);

        // Make frame visible
        frame.setVisible(true);
    }
}
