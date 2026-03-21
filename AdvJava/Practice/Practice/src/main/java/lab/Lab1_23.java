import javax.swing.*;
import java.awt.event.*;

public class Lab1_23 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Document Editor - Saudeep Adhikari");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label for name
        JLabel nameLabel = new JLabel("Saudeep Adhikari");
        frame.add(nameLabel, "North"); // display name at the top

        // Create MenuBar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Set menu bar to frame
        frame.setJMenuBar(menuBar);

        // Action for Exit menu item
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0); // close program
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
