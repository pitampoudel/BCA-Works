package pitam.swing;


//Includes KeyListener,MouseListener,ActionListener,Menu Bar, Menu Items, Border properties,Table

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.*;


import javax.swing.*;

/*The Mouse Listener in Java take actions whenever user hover the mouse to the component, 
clicked, pressed, released, entered or exited the component. You need to implement and override 
methods like mouseClicked, mousePressed, mouseReleased, mouseEntered, and mouseExited. */

/* Key Listener in Java handles all events pertaining to any action with regards to keyboard.
 * A method will be called whenever the user typed, pressed or released a key in the keyboard.
 */
public class MenuExample implements ActionListener, MouseListener, KeyListener {
    // create a frame
    static JFrame f;

    // menubar
    static JMenuBar mb;
    // JMenu
    static JMenu menu, submenu;
    // Menu items
    static JMenuItem m1, m2, m3, s1, s2;

    // a label
    static JLabel l, l1, lb, focasResult;
    JPanel panelBase;

    JPanel leftPanel, rightPanel, panelSouth, gridPanel;
    JTextArea textArea;
    private JScrollPane sc;

    public MenuExample() {
        // create a frame
        f = new JFrame("Menu demo");
        f.setLayout(new FlowLayout());

        // create a menubar
        mb = new JMenuBar();
        // create a menu
        menu = new JMenu("Menu");
        // create menuitems
        m1 = new JMenuItem("Menu Item1");
        m2 = new JMenuItem("Menu Item2");
        // add menu items to menu
        menu.add(m1);
        menu.add(m2);

        // add menu to menu bar
        mb.add(menu);
        // add ActionListener to menuItems
        m1.addActionListener(this);
        m2.addActionListener(this);
        // add menubar to frame
        f.setJMenuBar(mb);


        // create a label
        l = new JLabel("no task ");
        l1 = new JLabel("Raised Bevel Border");
        lb = new JLabel("Lowered Bevel Border");
        //1. Border createLineBorder(Color):	Create a line border. The first argument is a java.awt.Color
        //object that specifies the color of the line

        //2. Create a titled border. The string argument specifies the title to be displayed.
        l.setBorder(BorderFactory.createTitledBorder("Label"));

        //3. Create a border that gives the illusion of the component being higher than the surrounding area.
        //4. Create an etched border. The optional Color arguments specify the highlight and shadow colors to be used.
        l1.setBorder(BorderFactory.createRaisedBevelBorder());
        lb.setBorder(BorderFactory.createLoweredBevelBorder());

        // add label
        f.add(l);
        f.add(l1);
        f.add(lb);

        // panel
        panelBase = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 100));
        leftPanel.setBackground(Color.GREEN);
        leftPanel.addMouseListener(this);

        rightPanel.setPreferredSize(new Dimension(200, 100));
        rightPanel.setBackground(Color.BLUE);
        rightPanel.addMouseListener(this);

        textArea = new JTextArea();
        textArea.addKeyListener(this);

        TextField okButton = new TextField("OK");


        panelSouth = new JPanel();

        okButton.addFocusListener(new CustomFocusListener());
        panelSouth.add(okButton);

        focasResult = new JLabel("Focus Label");
        panelSouth.add(textArea);
        panelSouth.add(focasResult);


        panelBase.setLayout(new BorderLayout());
        panelBase.add(leftPanel, BorderLayout.WEST);
        panelBase.add(rightPanel, BorderLayout.EAST);
        panelBase.add(panelSouth, BorderLayout.SOUTH);


        // Table
        //gridPanel = new JPanel();
        String data[][] = {{"101", "Amit", "670000"},
                {"102", "Jai", "780000"},
                {"102", "Jai", "780000"},
                {"101", "Sachin", "700000"}};
        String column[] = {"ID", "NAME", "SALARY"};
        JTable jt = new JTable(data, column);

        //jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        sc = new JScrollPane();
        sc.setBounds(10, 208, 50, 5);
        sc.setViewportView(jt);
        //panelBase.add(sc, BorderLayout.NORTH);


        f.add(panelBase);

        // set the size of the frame
        f.setSize(500, 500);
        //  f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {

        new MenuExample();
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // set the label to the menuItem that is selected
        l.setText(s + " selected");

    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == leftPanel) {
            textArea.setText("You have clicked the left panel");
        } else {
            textArea.setText("You have clicked the right panel");
        }

    }

    public void mousePressed(MouseEvent e) {
        if (e.getSource() == leftPanel) {
            textArea.setText("You have pressed the left panel");
        } else {
            textArea.setText("You have pressed the right panel");
        }

    }

    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == leftPanel) {
            textArea.setText("You have released mouse on left panel");
        } else {
            textArea.setText("You have released mouse on right panel");
        }

    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == leftPanel) {
            textArea.setText("You have entered mouse on left panel");
        } else {
            textArea.setText("You have entered mouse on right panel");
        }

    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == leftPanel) {
            textArea.setText("You have exited mouse on left panel");
        } else {
            textArea.setText("You have exited mouse on right panel");
        }
    }


    public void keyPressed(KeyEvent e) {
        l.setText("You have pressed " + e.getKeyChar());

    }

    public void keyReleased(KeyEvent e) {
        l.setText("keyReleased " + e.getKeyChar());

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    class CustomFocusListener implements FocusListener {

        public void focusGained(FocusEvent e) {
            focasResult.setText(e.getComponent().getClass().getSimpleName() + " gained focus. ");
        }

        public void focusLost(FocusEvent e) {
            focasResult.setText(e.getComponent().getClass().getSimpleName() + " lost focus. ");
        }
    }

}
