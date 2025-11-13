package graphics.adapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapterExample extends KeyAdapter {
    Label label;

    public KeyAdapterExample() {
        JFrame frame = new JFrame("Key Adapter Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);

        label = new Label("Press a key");
        label.setBounds(100, 100, 100, 100);
        frame.add(label);
        frame.setVisible(true);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        label.setText("Key Pressed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        new KeyAdapterExample();
    }

}
