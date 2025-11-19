package mvc;

import javax.swing.*;

public class LoginPageExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();


        frame.add(panel);
        frame.setVisible(true);
    }
}
