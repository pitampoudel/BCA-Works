package graphics;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Modern Layout Example");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton button = new JButton("Click Me");
        panel.add(button,BorderLayout.SOUTH);

        frame.add(panel);

        frame.setVisible(true);
    }
}
