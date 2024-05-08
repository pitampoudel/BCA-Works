package pitam.swing;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class LayoutManager extends JFrame {

	//Layout refers to the arrangement of components within the container. 
	public LayoutManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	
		//FlowLayout: The FlowLayout is the default layout. It layout the components in a directional flow.
		
		var c = getContentPane();
		
        JPanel p1 = new JPanel();
        // borderlayout arranges the components to fit in the five regions: east, west, north, south, and center.
        p1.setLayout(new BorderLayout());
        p1.add(new JButton("A"), BorderLayout.NORTH);
        p1.add(new JButton("B"), BorderLayout.WEST);
        p1.add(new JButton("C"), BorderLayout.CENTER);
        p1.add(new JButton("D"), BorderLayout.EAST);
        p1.add(new JButton("E"), BorderLayout.SOUTH);
 
        
        JPanel p2 = new JPanel();
        //The GridLayout manages the components in the form of a rectangular grid.
        p2.setLayout(new GridLayout(3, 2));
        p2.add(new JButton("F"));
        
        p2.setBorder(new LineBorder(Color.BLACK));
        // Define the panel to hold the components
        JPanel panel = new JPanel();
        
        //This is the most flexible layout manager class. The object of GridBagLayout aligns the component vertically, horizontally, or along their
        //baseline without requiring the components of the same size.
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout); 
        GridBagConstraints gbc = new GridBagConstraints();
 
        // Put constraints on different buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JButton("GridBag "), gbc);
 
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JButton("Layout"), gbc);
 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 3"), gbc);
        p2.add(panel);
    
        p2.add(new JButton("H"));
        p2.add(new JButton("I"));
        p2.add(new JButton("J"));
        p2.add(new JButton("K"));
        
     
        JPanel p3 = new JPanel();
        //The Java BoxLayout class is used to arrange the components either vertically or horizontally. For this purpose, the BoxLayout class provides four constants.
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(new JButton("L"));
        p3.add(new JButton("M"));
        p3.add(new JButton("N"));
        p3.add(new JButton("O"));
        p3.add(new JButton("P"));

        
        c.setLayout(new BorderLayout());
        c.add(p1, BorderLayout.CENTER);
        c.add(p2, BorderLayout.SOUTH);
        c.add(p3, BorderLayout.EAST);
 
        pack();       
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutManager frame = new LayoutManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
