package pitam.swing;

import javax.swing.*;

//The JDesktopPane is a container which is used to create a multiple-document interface or a virtual desktop.
//The JFrame inside the desktop becomes JInternalFrame. JInternalFrame is used just like the JFrame but is 
//added to JDesktopPane object
public class JInternalFrameWithJDesktopPaneExample {
	  JFrame frame;
	  JPanel panel;
	  JInternalFrame iframe;	  
	  JButton button1, button2;
	  JDesktopPane desk;
	  public JInternalFrameWithJDesktopPaneExample(){
		  frame = new JFrame("Creating a JDesktopPane Container");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		  iframe = new JInternalFrame("Internal frame", true,true,true,true);
		  iframe.setToolTipText("This is internal frame");
		  
		  button1 = new JButton("Ok");
		  button1.setToolTipText("This is Ok button of internal frame");
		  
		  panel = new JPanel();
		  panel.add(button1);
		  
		  button2 = new JButton("Cancel");
		  button2.setToolTipText("This is cancel button of internal frame");
		  panel.add(button2);
		  
		  iframe.add(panel);
		  iframe.setSize(250,300);
		  iframe.setVisible(true);
		  
		  desk = new JDesktopPane();
		  desk.add(iframe);
		  
		  frame.add(desk);
		  
		  frame.setSize(400,400);
		  frame.setVisible(true);
		  }
	public static void main(String[] args) {
		 new JInternalFrameWithJDesktopPaneExample();

	}

}
