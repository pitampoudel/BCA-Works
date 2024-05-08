package pitam.swing;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.*;

//The Model-View-Controller is a well known software architectural pattern that separates an 
//application into three main logical components  . 
//Main goal of Model-View-Controller, also known as MVC, is to separate internal representations of an 
//application from the ways information are presented to the user.

//Model=> that manages data, logic and rules of the application
//View=> that is used to present data to user
//Controller=> that accepts input from the user and converts it to commands for the Model or View.
class LModel
{
	public String[] GetList()
	{
		return new String[] { "Apple", "Orange", "Banana" };
	}	
}

class LView
{
	JFrame frame;
	JList list;
	public LView(String title)
	{
		
		if(title==null)
			title="dipak";
		
		frame = new JFrame(title);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 120);
		
		var layout= new SpringLayout();
		
		list= new JList();
		//list.setListData(new String[] { "Apple", "Orange", "Banana" });
		
		layout.putConstraint(title, list, 8, title, frame);
		frame.setLayout(layout);
		
		frame.add(list);
		frame.setVisible(true);
	}
	public JList JList()
	{
		return list;
	}	
}

class LController {
	private LModel model;
	private LView view;

	public LController(LModel m, LView v) {
		model = m;
		view = v;
		 initView();
	}

	public void initView() {
		var list=view.JList();
		var modelData=model.GetList();
		list.setListData(modelData);
	}

}

public class MVCList {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                	 // Assemble all the pieces of the MVC
          		  LModel m = new LModel();
          		  LView v = new LView("List with MVC");
          		  LController c = new LController(m, v);
          		//  c.initController();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
