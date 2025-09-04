import javax.swing.*;

public class JFrameExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("First GUI Application");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
