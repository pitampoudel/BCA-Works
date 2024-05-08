package pitam.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingFormComponent extends JFrame {

	private JPanel contentPane;
	private JTextField Num1;
	private JTextField txtNum2;	
	//private JLabel lblSum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingFormComponent frame = new SwingFormComponent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingFormComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 500, 600, 300);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumOne = new JLabel("Num 1");
		lblNumOne.setBounds(5, 5, 574, 14);
		contentPane.add(lblNumOne);
		
		Num1 = new JTextField();
		Num1.setBackground(Color.GREEN);
		Num1.setBounds(50, 5, 86, 20);
		contentPane.add(Num1);		
		
		JLabel lblNumTwo = new JLabel("Num 2");
		lblNumTwo.setBounds(5, 40, 46, 14);
		contentPane.add(lblNumTwo);
		
		txtNum2 = new JTextField();
		txtNum2.setBounds(60, 36, 86, 20);
		contentPane.add(txtNum2);		
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(43, 71, 103, 21);
		bg.add(rdbtnNewRadioButton);
		
		contentPane.add(rdbtnNewRadioButton);
		
		String[] countries= {"Nepal","India"};
		JComboBox cmbCountry = new JComboBox(countries);
		cmbCountry.setBounds(78, 108, 100, 21);
		contentPane.add(cmbCountry);
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				var number1=Num1.getText();	
				var numb2=txtNum2.getText();
				
				
				
				var maleSelected=rdbtnNewRadioButton.isSelected();
				var feMaleSelected=rdbtnNewRadioButton.isSelected();
				
				var selectedCmbIndex=cmbCountry.getSelectedIndex();
				
				var coutryName=countries[selectedCmbIndex];
				
				
				
				txtNum2.setText("Abc");
				

				//JOptionPane.showMessageDialog(null,"Male seleted: "+coutryName);
			}
		});
		btnNewButton.setBounds(38, 214, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(5, 75, 45, 13);
		contentPane.add(lblGender);
		
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(159, 71, 103, 21);	
		bg.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1);
		
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(15, 112, 80, 13);
		Font fn=new Font("serif",Font.BOLD,14);
		
		lblCountry.setFont(fn);;
		
		contentPane.add(lblCountry);
		
		
	}
}
