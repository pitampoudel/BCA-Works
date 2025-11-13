package graphics.adapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotionAdapterExample extends MouseMotionAdapter {
    JFrame frame;

    public MouseMotionAdapterExample() {
        frame = new JFrame("Mouse Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.addMouseMotionListener(this);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseAdapterExample();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        super.mouseDragged(mouseEvent);
        Graphics g = frame.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(mouseEvent.getX(), mouseEvent.getY(), 20, 20);
    }

}
