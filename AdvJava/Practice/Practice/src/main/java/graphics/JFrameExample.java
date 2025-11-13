package graphics;

import javax.swing.*;
import java.net.URL;

public class JFrameExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("First GUI Application");
        URL imageUrl = JFrameExample.class.getResource("/icon.png");
        frame.setIconImage(new ImageIcon(imageUrl).getImage());
        frame.setSize(500, 500);
        //full screen on default
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // center of screen
        frame.setLocationRelativeTo(null);
        //
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(imageUrl);
        frame.add(new JLabel(icon));


        frame.setVisible(true);

    }
}
