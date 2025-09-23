package skillbuilders;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class semesterAvg {

    private JFrame frame;
    private JTextField textField_1;
    private JTextField textField;
    private JTextField textField_2;

   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    semesterAvg window = new semesterAvg();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public semesterAvg() {
        initialize();
    }

 
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 436, 250);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2_2 = new JLabel("Enter the first grade");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_2.setBounds(16, 15, 145, 44);
        panel.add(lblNewLabel_2_2);

        textField_1 = new JTextField();
        textField_1.setBounds(196, 11, 202, 51);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Enter the second grade");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(15, 77, 145, 44);
        panel.add(lblNewLabel_2_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(196, 73, 202, 51);
        panel.add(textField);

        JLabel lblEnterTheThird = new JLabel("Enter the third grade");
        lblEnterTheThird.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEnterTheThird.setBounds(13, 138, 145, 44);
        panel.add(lblEnterTheThird);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(196, 135, 202, 51);
        panel.add(textField_2);

        JButton btnNewButton = new JButton("Average");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(23, 193, 123, 46);
        panel.add(btnNewButton);

        JTextArea disp = new JTextArea();
        disp.setBackground(UIManager.getColor("Button.background"));
        disp.setBounds(195, 193, 208, 44);
        panel.add(disp);

       
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double g1 = Double.parseDouble(textField_1.getText());
                    double g2 = Double.parseDouble(textField.getText());
                    double g3 = Double.parseDouble(textField_2.getText());

                    double avg = (g1 + g2 + g3) / 3.0;
                    disp.setText("Average: " + String.format("%.2f", avg));
                } catch (NumberFormatException ex) {
                    disp.setText("Please enter valid numbers.");
                }
            }
        });
    }
}
