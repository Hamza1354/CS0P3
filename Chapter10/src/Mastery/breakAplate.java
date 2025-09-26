package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class breakAplate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					breakAplate window = new breakAplate();
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
	public breakAplate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel centerImageLabel = new JLabel((Icon) null, SwingConstants.CENTER);
		centerImageLabel.setBounds(0, 44, 584, 124);
		frame.getContentPane().add(centerImageLabel);
		
		JButton playButton = new JButton("Play");
		playButton.setBounds(234, 197, 97, 23);
		frame.getContentPane().add(playButton);
		
		JLabel centerImageLabel_1 = new JLabel((Icon) null, SwingConstants.CENTER);
		centerImageLabel_1.setBounds(219, 248, 136, 124);
		frame.getContentPane().add(centerImageLabel_1);
	}

}
