package Mastery;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class breakAplate implements ActionListener {

    private JFrame frame;
    private JLabel platesLabel;
    private JLabel prizeLabel;
    private JButton playButton;

    private static final String FIRST_PRIZE = "tiger plush";
    private static final String CONSOLATION_PRIZE = "sticker";

    private GameBooth breakAPlate;

    /**
     * GameBooth class simulates the game logic.
     */
    public class GameBooth {
        private int cost;
        private String firstPrize;
        private String consolationPrize;

        public GameBooth(int cost, String firstPrize, String consolationPrize) {
            this.cost = cost;
            this.firstPrize = firstPrize;
            this.consolationPrize = consolationPrize;
        }

        public String start() {
            // Generate three random numbers (0 or 1)
            int countOnes = 0;
            for (int i = 0; i < 3; i++) {
                if ((int) (Math.random() * 2) == 1) {
                    countOnes++;
                }
            }
            if (countOnes == 3) {
                return firstPrize;
            } else {
                return consolationPrize;
            }
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                breakAplate window = new breakAplate();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public breakAplate() {
        breakAPlate = new GameBooth(0, FIRST_PRIZE, CONSOLATION_PRIZE);
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("BreakAPlate");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 451, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        platesLabel = new JLabel();
        platesLabel.setBounds(10, 43, 425, 77);
        platesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(platesLabel);

        playButton = new JButton("Play");
        playButton.setBounds(152, 140, 136, 23);
        playButton.setActionCommand("Play");
        playButton.addActionListener(this);
        frame.getContentPane().add(playButton);

        prizeLabel = new JLabel();
        prizeLabel.setBounds(152, 193, 136, 124);
        prizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(prizeLabel);

        resetGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("Play".equals(cmd)) {
            String prize = breakAPlate.start();

            if (FIRST_PRIZE.equals(prize)) {
                platesLabel.setIcon(new ImageIcon(getClass().getResource("plates_all_broken.gif")));
                prizeLabel.setIcon(new ImageIcon(getClass().getResource("tiger_plush.gif")));
            } else {
                platesLabel.setIcon(new ImageIcon(getClass().getResource("plates_two_broken.gif")));
                prizeLabel.setIcon(new ImageIcon(getClass().getResource("sticker.gif")));
            }
            playButton.setText("Play Again");
            playButton.setActionCommand("Play Again");

        } else if ("Play Again".equals(cmd)) {
            resetGame();
        }
    }

    private void resetGame() {
        platesLabel.setIcon(new ImageIcon(getClass().getResource("plates.gif")));
        prizeLabel.setIcon(new ImageIcon(getClass().getResource("placeholder.gif")));
        playButton.setText("Play");
        playButton.setActionCommand("Play");
    }
}
