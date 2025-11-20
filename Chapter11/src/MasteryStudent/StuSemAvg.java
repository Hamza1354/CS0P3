package MasteryStudent;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class StuSemAvg {

    private static final String FILE_PATH = "student_grades.txt";
    private JFrame win;
    private JTextField tfName, tfLevel, tfSem, tfG1, tfG2, tfG3, tfG4, tfAvg;
    private JTextArea taData;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new StuSemAvg().launch();
        });
    }

    private void launch() {
        win = new JFrame("Grades Manager");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(800, 500);
        win.setLocationRelativeTo(null);
        win.setLayout(new BorderLayout());
        
        win.add(constructInputPanel(), BorderLayout.WEST);
        win.add(constructDisplayPanel(), BorderLayout.CENTER);
        win.add(constructActionPanel(), BorderLayout.SOUTH);
        
        win.setVisible(true);
    }

    // Input Panel construction
    private JPanel constructInputPanel() {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(310, 0));
        p.setBorder(new TitledBorder("Input Student Data"));
        p.setLayout(new GridLayout(8, 2, 10, 8));
        
        tfName = new JTextField(15);
        tfLevel = new JTextField(15);
        tfSem = new JTextField(15);
        tfG1 = new JTextField(15);
        tfG2 = new JTextField(15);
        tfG3 = new JTextField(15);
        tfG4 = new JTextField(15);
        tfAvg = new JTextField(15);
        tfAvg.setEditable(false);
        
        p.add(new JLabel("Student Name:"));
        p.add(tfName);

        p.add(new JLabel("Grade Level:"));
        p.add(tfLevel);

        p.add(new JLabel("Semester:"));
        p.add(tfSem);

        p.add(new JLabel("Grade 1:"));
        p.add(tfG1);

        p.add(new JLabel("Grade 2:"));
        p.add(tfG2);

        p.add(new JLabel("Grade 3:"));
        p.add(tfG3);

        p.add(new JLabel("Grade 4:"));
        p.add(tfG4);

        p.add(new JLabel("Average:"));
        p.add(tfAvg);

        return p;
    }

    // Data display panel
    private JScrollPane constructDisplayPanel() {
        taData = new JTextArea();
        taData.setEditable(false);
        taData.setFont(new Font("Consolas", Font.PLAIN, 13));
        return new JScrollPane(taData);
    }

    // Control panel with actions
    private JPanel constructActionPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 8));

        JButton btnCompute = new JButton("Compute & Save");
        btnCompute.addActionListener(e -> computeAndSave());

        JButton btnLoad = new JButton("Show Records");
        btnLoad.addActionListener(e -> showRecords());

        JButton btnReset = new JButton("Clear Fields");
        btnReset.addActionListener(e -> clearFields());

        panel.add(btnCompute);
        panel.add(btnLoad);
        panel.add(btnReset);

        return panel;
    }

    // Compute, display, and save student average
    private void computeAndSave() {
        String name = tfName.getText();
        String level = tfLevel.getText();
        String semester = tfSem.getText();
        String[] gradesText = { tfG1.getText(), tfG2.getText(), tfG3.getText(), tfG4.getText() };
        
        if (name.isEmpty() || level.isEmpty() || semester.isEmpty() || hasEmpty(gradesText)) {
            showError("All fields are required!");
            return;
        }

        try {
            double[] grades = new double[4];
            for (int i = 0; i < 4; ++i) grades[i] = Double.parseDouble(gradesText[i]);

            double avg = (grades[0] + grades[1] + grades[2] + grades[3]) / 4.0;
            tfAvg.setText(String.format("%.2f", avg));

            String output = String.format("Name: %s | Level: %s | Sem: %s | G: %.1f %.1f %.1f %.1f | Avg: %.2f", name, level, semester, grades[0], grades[1], grades[2], grades[3], avg);
            saveLineToFile(output);
            showInfo("Data stored successfully.");
        } catch (NumberFormatException nfe) {
            showError("Grades must be numeric.");
        }
    }

    private void showRecords() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String ln;
            while ((ln = br.readLine()) != null) sb.append(ln).append('\n');
        } catch (IOException ex) {
            sb.append("No records found yet.");
        }
        taData.setText(sb.toString());
    }

    private boolean hasEmpty(String[] data) {
        for (String s : data) if (s.trim().isEmpty()) return true;
        return false;
    }

    private void saveLineToFile(String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(record); bw.newLine();
        } catch (IOException io) {
            showError("File write error.");
        }
    }

    private void clearFields() {
        tfName.setText("");
        tfLevel.setText("");
        tfSem.setText("");
        tfG1.setText("");
        tfG2.setText("");
        tfG3.setText("");
        tfG4.setText("");
        tfAvg.setText("");
    }

    // Dialogs
    private void showError(String msg) {
        JOptionPane.showMessageDialog(win, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void showInfo(String msg) {
        JOptionPane.showMessageDialog(win, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
