package graphics;

import javax.swing.*;

public class JFrameExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("First GUI Application");
        frame.setIconImage(new ImageIcon("src/main/resources/icon.png").getImage());
        frame.setSize(500, 500);
        //full screen on default
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // center of screen
        frame.setLocationRelativeTo(null);
        //
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
        frame.add(new JLabel(icon));


        frame.setVisible(true);

    }
}
