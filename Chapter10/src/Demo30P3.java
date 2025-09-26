import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Demo30P3 {

	private JFrame frame;
	private JTextField Fn;
	private JTextField Ln;
	private JComboBox grades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo30P3 window = new Demo30P3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo30P3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	
	
	
	private void initialize()
	
	{
		ImageIcon logo = new ImageIcon(" /Chapter10/src/skillbuilders/logo 2.jpeg ");
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-32, 0, 815, 539);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Fn = new JTextField();
		Fn.addKeyListener(new KeyAdapter() 
		{
			
			
			@Override
			public void keyTyped(KeyEvent e) 
			
			{
				
				
				if(Fn.getText().equals("first name"))
				     Fn.setText("");
				
			
			}
		});
		Fn.setForeground(new Color(192, 192, 192));
		Fn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Fn.setText("first name");
		Fn.setBounds(110, 68, 142, 36);
		panel.add(Fn);
		Fn.setColumns(10);
		
		Ln = new JTextField();
		Ln.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			
			
			{
				
				if(Ln.getText().equals("last name"))
				     Ln.setText("");
			}
		});
		Ln.setForeground(new Color(192, 192, 192));
		Ln.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ln.setText("last name");
		Ln.setColumns(10);
		Ln.setBounds(370, 68, 122, 36);
		panel.add(Ln);
		
		JComboBox Grades = new JComboBox();
		Grades.setForeground(new Color(128, 0, 0));
		Grades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Grades.setModel(new DefaultComboBoxModel(new String[] {"Select Grade Level:", "12", "11", "10"}));
		Grades.setBounds(93, 163, 159, 36);
		panel.add(Grades);
		
		grades = new JComboBox();
		grades.setModel(new DefaultComboBoxModel(new String[] {"Select School:", "Crescent Heights", "James Fowler", "LB Pearson", "Western"}));
		grades.setForeground(new Color(0, 0, 255));
		grades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grades.setBounds(352, 163, 174, 36);
		panel.add(grades);
		
		
		
		JTextArea disp = new JTextArea();
		disp.setForeground(new Color(0, 0, 0));
		disp.setBackground(new Color(255, 255, 255));
		disp.setBounds(64, 220, 530, 125);
		panel.add(disp);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String grade =" ";
				String school =" ";
				
				String firstN = Fn.getText();
				String lastN = Ln.getText();
				
				if ( Grades.getSelectedItem().equals("12"))
				{
					
				grade = "12";
					
				}
				else if(Grades.getSelectedItem().equals("11"))
					
				{
					
					grade = "11";
				}
				else 
				{
					
					grade = "10";
				}
				
				
				if (school.getSelectedItem().equals("12"))
				{
					
				grade = "12";
					
				}
				else if(Grades.getSelectedItem().equals("11"))
					
				{
					
					grade = "11";
				}
				else 
				{
					
					grade = "10";
				}
				disp.setText(firstN + " " + lastN + " is in grade " + grade ); 
			}
		});
		Submit.setFont(new Font("Tahoma", Font.ITALIC, 18));
		Submit.setBounds(626, 62, 132, 236);
		panel.add(Submit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(463, 386, 257, 112);
		panel.add(lblNewLabel);
	}
}
