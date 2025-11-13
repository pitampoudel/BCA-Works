package graphics.adapters;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterExample extends MouseAdapter {
    JFrame frame;

    public MouseAdapterExample() {
        frame = new JFrame("Mouse Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.addMouseListener(this);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseAdapterExample();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("Mouse clicked at: " + mouseEvent.getX() + ", " + mouseEvent.getY());

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("Mouse pressed at: " + mouseEvent.getX() + ", " + mouseEvent.getY());

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        System.out.println("Mouse released at: " + mouseEvent.getX() + ", " + mouseEvent.getY());

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println("Mouse entered at: " + mouseEvent.getX() + ", " + mouseEvent.getY());

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("Mouse exited at: " + mouseEvent.getX() + ", " + mouseEvent.getY());

    }
}
