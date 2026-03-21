import javax.swing.*;

public class MdiDemo extends JFrame {

    public MdiDemo() {
        setTitle("MDI Demo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();

        JInternalFrame frame1 = new JInternalFrame("Window 1", true, true, true, true);
        frame1.setSize(200, 150);
        frame1.setLocation(30, 30);
        frame1.setVisible(true);

        JInternalFrame frame2 = new JInternalFrame("Window 2", true, true, true, true);
        frame2.setSize(200, 150);
        frame2.setLocation(260, 80);
        frame2.setVisible(true);

        desktopPane.add(frame1);
        desktopPane.add(frame2);

        add(desktopPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MdiDemo().setVisible(true);
        });
    }
}