import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorChooserDemo extends JFrame {

    private final JPanel panel;

    public ColorChooserDemo() {
        setTitle("Color Panel Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JButton button = new JButton("Choose Color");

        button.addActionListener((ActionEvent e) -> {
            Color selectedColor = JColorChooser.showDialog(
                    this,
                    "Select a Color",
                    panel.getBackground()
            );

            if (selectedColor != null) {
                panel.setBackground(selectedColor);
            }
        });

        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ColorChooserDemo().setVisible(true);
        });
    }
}