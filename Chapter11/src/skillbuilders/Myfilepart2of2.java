package skillbuilders;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Myfilepart2of2 {
    private JFrame frame;
    private static final String FILE_PATH = "C:\\Users\\48051002\\git\\CS0P3\\Chapter11\\src\\demos\\zzz.txt";
    private File textFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Myfilepart2of2 window = new Myfilepart2of2();
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
    public Myfilepart2of2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        textFile = new File(FILE_PATH);

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel disp = new JLabel("");
        disp.setBounds(112, 52, 218, 51);
        panel.add(disp);

        JButton keepBtn = new JButton("Keep File");
        keepBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFile.exists()) {
                    disp.setText("The file already exists");
                } else {
                    try {
                        if (textFile.createNewFile()) {
                            disp.setText("The file has been created.");
                        } else {
                            disp.setText("The file could not be created.");
                        }
                    } catch (IOException ex) {
                        disp.setText("Error: " + ex.getMessage());
                        System.err.println("IOException: " + ex.getMessage());
                    }
                }
            }
        });
        keepBtn.setBounds(112, 114, 89, 51);
        panel.add(keepBtn);

        JButton delBtn = new JButton("Delete File");
        delBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFile.exists() && textFile.delete()) {
                    disp.setText("The file has been deleted.");
                } else {
                    disp.setText("Failed to delete the file.");
                }
            }
        });
        delBtn.setBounds(241, 114, 89, 51);
        panel.add(delBtn);
    }
}
