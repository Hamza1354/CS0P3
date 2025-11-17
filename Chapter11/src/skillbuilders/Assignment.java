package skillbuilders;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Assignment {
   private JFrame frame;
   private JTextArea textArea;
   private JTextField pathField;
   private JButton loadButton;
   private JLabel instructionLabel;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
       EventQueue.invokeLater(() -> {
           try {
               Assignment window = new Assignment();
               window.frame.setVisible(true);
           } catch (Exception e) {
               e.printStackTrace();
           }
       });
   }
   /**
    * Create the application.
    */
   public Assignment() {
       initialize();
   }
   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
       frame = new JFrame("Assignment Reader");
       frame.setBounds(100, 100, 600, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setLayout(null);
       frame.getContentPane().setBackground(Color.WHITE);
       instructionLabel = new JLabel("Enter the file name or full path to display contents:");
       instructionLabel.setBounds(20, 15, 540, 20);
       frame.getContentPane().add(instructionLabel);
       pathField = new JTextField("");
       pathField.setBounds(20, 40, 400, 25);
       frame.getContentPane().add(pathField);
       loadButton = new JButton("Load File");
       loadButton.setBounds(430, 40, 130, 25);
       frame.getContentPane().add(loadButton);
       textArea = new JTextArea();
       textArea.setEditable(false);
       textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
       JScrollPane scrollPane = new JScrollPane(textArea);
       scrollPane.setBounds(20, 80, 540, 260);
       frame.getContentPane().add(scrollPane);
       // Action Listener
       loadButton.addActionListener(e -> loadFile());
   }
   /**
    * Load and display file contents
    */
   private void loadFile() {
       String path = pathField.getText().trim();
       File file = new File(path);
       // If no directory specified, assume current working directory
       if (!file.exists()) {
       	if (!file.exists()) {
       	    String altPath = System.getProperty("user.dir")
       	                   + File.separator + "src"
       	                   + File.separator + "SkillBuilders"
       	                   + File.separator + path;
       	    file = new File(altPath);
       	}
       }
       try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
           textArea.setText(""); // clear old text
           String line;
           while ((line = reader.readLine()) != null) {
               textArea.append(line + "\n");
           }
       } catch (FileNotFoundException fnfe) {
           textArea.setText("❌ File not found: " + file.getAbsolutePath());
       } catch (IOException ioe) {
           textArea.setText("⚠️ Error reading file: " + ioe.getMessage());
       }
   }
}
