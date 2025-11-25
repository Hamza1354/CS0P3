package skillbuilders;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.NumberFormat;
import javax.swing.*;

public class StatsP2GUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea resultArea;
    private JButton createFileButton;
    private JButton analyzeButton;
    private JLabel titleLabel;
    private JTextField fileNameField;
    private JTextField numStudentsField;

    public StatsP2GUI() {
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Student Statistics Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Main panel
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title
        titleLabel = new JLabel("Student Data File Manager", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 0, 128));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("File Configuration"));

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameField = new JTextField("");
        JLabel numStudentsLabel = new JLabel("Number of Students:");
        numStudentsField = new JTextField("");

        inputPanel.add(fileNameLabel);
        inputPanel.add(fileNameField);
        inputPanel.add(numStudentsLabel);
        inputPanel.add(numStudentsField);

        // Buttons
        createFileButton = new JButton("Create Data File");
        createFileButton.setFont(new Font("Arial", Font.BOLD, 14));
        createFileButton.setBackground(new Color(70, 130, 180));
        createFileButton.setForeground(Color.WHITE);
        createFileButton.setFocusPainted(false);

        analyzeButton = new JButton("Analyze Scores");
        analyzeButton.setFont(new Font("Arial", Font.BOLD, 14));
        analyzeButton.setBackground(new Color(60, 179, 113));
        analyzeButton.setForeground(Color.WHITE);
        analyzeButton.setFocusPainted(false);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(createFileButton);
        buttonPanel.add(analyzeButton);

        // Result area
        resultArea = new JTextArea(15, 50);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        resultArea.setBackground(new Color(240, 240, 240));
        resultArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Button listeners
        createFileButton.addActionListener(e -> createDataFile());
        analyzeButton.addActionListener(e -> analyzeScores());

        // Layout
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    private void createDataFile() {
        String fileName = fileNameField.getText().trim();
        String numStudentsText = numStudentsField.getText().trim();

        if (fileName.isEmpty() || numStudentsText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter both file name and number of students.",
                "Input Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int numStu = Integer.parseInt(numStudentsText);
            StringBuilder studentData = new StringBuilder();

            // Overwrite file if it exists
            try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName, false))) {
                for (int i = 0; i < numStu; i++) {
                    JPanel inputDialog = new JPanel(new GridLayout(2, 2, 5, 5));
                    JTextField nameField = new JTextField();
                    JTextField scoreField = new JTextField();
                    inputDialog.add(new JLabel("Student Name:"));
                    inputDialog.add(nameField);
                    inputDialog.add(new JLabel("Test Score:"));
                    inputDialog.add(scoreField);

                    int result = JOptionPane.showConfirmDialog(this, inputDialog,
                        "Enter data for Student " + (i + 1),
                        JOptionPane.OK_CANCEL_OPTION);

                    if (result != JOptionPane.OK_OPTION) {
                        break;
                    }

                    String stuName = nameField.getText().trim();
                    String score = scoreField.getText().trim();

                    if (stuName.isEmpty() || score.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                            "Please enter both name and score for student " + (i + 1),
                            "Input Error",
                            JOptionPane.WARNING_MESSAGE);
                        i--;
                        continue;
                    }
                    // Validate score
                    try {
                        Double.parseDouble(score);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this,
                            "Please enter a valid number for the score.",
                            "Input Error",
                            JOptionPane.WARNING_MESSAGE);
                        i--;
                        continue;
                    }

                    studentData.append(stuName).append(": ").append(score).append("\n");
                    writeFile.write(stuName);
                    writeFile.newLine();
                    writeFile.write(score);
                    writeFile.newLine();
                }
            }

            resultArea.setText("Data written to file: " + fileName + "\n\n");
            resultArea.append("STUDENTS ENTERED:\n");
            resultArea.append("----------------\n");
            resultArea.append(studentData.toString());
            resultArea.append("\nFile created successfully!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Please enter a valid number for students.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                "File could not be created: " + e.getMessage(),
                "File Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void analyzeScores() {
        String fileName = fileNameField.getText().trim();

        if (fileName.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter a file name first.",
                "Input Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        resultArea.setText("");
        File dataFile = new File(fileName);

        double lowScore = 100;
        double highScore = 0;
        double avgScore;
        double totalScore = 0;
        int numScores = 0;
        NumberFormat percent = NumberFormat.getPercentInstance();
        StringBuilder output = new StringBuilder();

        try (BufferedReader readFile = new BufferedReader(new FileReader(dataFile))) {
            output.append("STUDENT SCORES:\n");
            output.append("---------------\n");

            String stuName, score;
            while ((stuName = readFile.readLine()) != null && (score = readFile.readLine()) != null) {
                numScores++;
                double scoreValue = Double.parseDouble(score);
                output.append(stuName + " " + percent.format(scoreValue / 100) + "\n");
                totalScore += scoreValue;
                if (scoreValue < lowScore) lowScore = scoreValue;
                if (scoreValue > highScore) highScore = scoreValue;
            }

            if (numScores > 0) {
                avgScore = totalScore / numScores;
                output.append("\nSTATISTICS:\n");
                output.append("-----------\n");
                output.append("Low score: " + percent.format(lowScore / 100) + "\n");
                output.append("High score: " + percent.format(highScore / 100) + "\n");
                output.append("Average score: " + percent.format(avgScore / 100) + "\n");
                output.append("Total students: " + numScores + "\n");
            } else {
                output.append("\nNo student data found.\n");
            }

            resultArea.setText(output.toString());

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                "File does not exist or could not be found.\n" +
                    "Please check the file path: " + dataFile.getPath(),
                "File Not Found",
                JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                "Problem reading file: " + e.getMessage(),
                "Read Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Error parsing score data: " + e.getMessage(),
                "Data Format Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Set look and feel if desired (optional)
        SwingUtilities.invokeLater(() -> {
            StatsP2GUI frame = new StatsP2GUI();
            frame.setVisible(true);
        });
    }
}
