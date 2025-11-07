package graphics;

import javax.swing.*;
import java.awt.*;

public class ListFonts {

    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JFrame frame = new JFrame("List Fonts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        //fonts
        JPanel fontPanel = new JPanel();
        fontPanel.setLayout(new BoxLayout(fontPanel, BoxLayout.Y_AXIS));
        for (String fontName : fontNames) {
            JLabel text1 = new JLabel(fontName);
            text1.setFont(new Font(fontName, Font.PLAIN, 20));
            text1.setAlignmentX(Component.CENTER_ALIGNMENT);
            fontPanel.add(text1);
        }

        // scroll pane
        JScrollPane scrollPane = new JScrollPane(fontPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
