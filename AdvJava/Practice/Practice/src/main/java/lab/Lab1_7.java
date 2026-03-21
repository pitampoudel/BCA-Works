import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Lab1_7 extends JFrame {
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public Lab1_7() {
        label = new JLabel ("King is back .........", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        ActionListener listener = event -> {
            int mode = 0;
            if (bold.isSelected()) mode += Font.BOLD;
            if (italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode,40));
        };
        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout. SOUTH);
        pack();
    }
    public static  void main(String[] args) {
        JFrame frame = new Lab1_7();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CheckBox Example");
        frame.setVisible(true);
        JLabel nameLabel = new JLabel("Saudeep Adhikari", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        frame.add(nameLabel, BorderLayout.NORTH);
    }
}


