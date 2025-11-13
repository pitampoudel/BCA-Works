package graphics;

import javax.swing.*;
import java.awt.*;

public class EventListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> jPanel.setBackground(Color.RED));
        jPanel.add(button);
        frame.add(jPanel);

        frame.setVisible(true);
    }
}
