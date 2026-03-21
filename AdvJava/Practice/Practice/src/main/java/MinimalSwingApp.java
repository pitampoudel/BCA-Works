import javax.swing.*;

public class MinimalSwingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minimal Swing App");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // vertical layout

        panel.add(new JLabel("Hello, Swing!"));
        panel.add(new JButton("Click Me"));

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}