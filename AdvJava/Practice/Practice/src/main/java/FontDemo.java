import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FontDemo extends JFrame {

    private final JLabel label;

    public FontDemo() {
        setTitle("Font Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        label = new JLabel("Sample Text", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton button = new JButton("Choose Font");

        button.addActionListener((ActionEvent e) -> showFontDialog());

        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    private void showFontDialog() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();

        String selectedFont = (String) JOptionPane.showInputDialog(
                this,
                "Select Font:",
                "Font Chooser",
                JOptionPane.PLAIN_MESSAGE,
                null,
                fonts,
                fonts[0]
        );

        if (selectedFont != null) {
            label.setFont(new Font(selectedFont, Font.PLAIN, 24));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FontDemo().setVisible(true);
        });
    }
}