package skillbuilders;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class StatsPart1of2 {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StatsPart1of2 window = new StatsPart1of2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StatsPart1of2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 931, 683);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel TitleLabel = new JLabel("Student Test Scores Analysis");
        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        TitleLabel.setBounds(10, 23, 895, 65);
        panel.add(TitleLabel);

        JTextArea ResultArea = new JTextArea();
        ResultArea.setEditable(false);
        ResultArea.setRows(15);
        ResultArea.setColumns(40);
        ResultArea.setBorder(new LineBorder(new Color(0, 0, 0)));
        ResultArea.setBackground(new Color(240, 240, 240));
        ResultArea.setBounds(61, 117, 788, 363);
        panel.add(ResultArea);

        JButton AnalyzeButton = new JButton("Analyze Scores");
        AnalyzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear previous results
                ResultArea.setText("");

                File dataFile = new File("..\\Chapter11\\src\\skillbuilders\\test.txt");
                FileReader in;
                BufferedReader readFile;

                String stuName, score;

                double scoreValue;
                double lowScore = 100;
                double highScore = 0;
                double avgScore = 0;
                double totalScore = 0;
                int numScores = 0;

                NumberFormat percent = NumberFormat.getPercentInstance();

                StringBuilder output = new StringBuilder();

                try {
                    in = new FileReader(dataFile);
                    readFile = new BufferedReader(in);

                    output.append("STUDENT SCORES:\n");
                    output.append("--------------------\n");

                    while ((stuName = readFile.readLine()) != null) {
                        score = readFile.readLine();
                        if (score == null) break; // Handle uneven pairs

                        numScores += 1;

                        try {
                            scoreValue = Double.parseDouble(score);

                            output.append(stuName + " " + percent.format(scoreValue / 100) + "\n");

                            totalScore += scoreValue;

                            if (scoreValue < lowScore)
                                lowScore = scoreValue;

                            if (scoreValue > highScore)
                                highScore = scoreValue;

                        } catch (NumberFormatException nfe) {
                            output.append(stuName + " [INVALID SCORE]\n");
                        }
                    }

                    if (numScores > 0)
                        avgScore = totalScore / numScores;

                    output.append("\nSTATISTICS:\n");
                    output.append("-----------------\n");
                    output.append("Low Score: " + percent.format(lowScore / 100) + "\n");
                    output.append("High Score: " + percent.format(highScore / 100) + "\n");
                    output.append("Average Score: " + percent.format(avgScore / 100) + "\n");
                    output.append("Total Students: " + numScores + "\n");

                    ResultArea.setText(output.toString());

                    readFile.close();
                    in.close();

                } catch (FileNotFoundException ex) {
                    ResultArea.setText("File could not be found.\n");
                } catch (IOException ex) {
                    ResultArea.setText("Problem reading file.\n");
                }
            }
        });

        AnalyzeButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
        AnalyzeButton.setBounds(216, 505, 468, 106);
        panel.add(AnalyzeButton);
    }
}
