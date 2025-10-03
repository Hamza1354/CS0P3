package Mastery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] buttons = new JButton[9];
    private char currentPlayer = 'X';
    private JLabel statusLabel;

    public TicTacToeGUI() {
        setTitle("TicTacToeGUI");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        Font buttonFont = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(buttonFont);
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            boardPanel.add(buttons[i]);
        }

        statusLabel = new JLabel("Game in progress", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        add(boardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton)e.getSource();

        if (!clickedButton.getText().equals("") || isGameOver()) {
            return; // Ignore if already clicked or game over
        }

        clickedButton.setText(String.valueOf(currentPlayer));

        if (checkWinner()) {
            statusLabel.setText("The winner is: " + currentPlayer);
            disableButtons();
        } else if (isBoardFull()) {
            statusLabel.setText("Game ended in a draw.");
        } else {
            switchPlayer();
            statusLabel.setText("Current player: " + currentPlayer);
        }
    }

    private boolean checkWinner() {
        int[][] winningIndices = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        for (int[] line : winningIndices) {
            if (!buttons[line[0]].getText().equals("") &&
                buttons[line[0]].getText().equals(buttons[line[1]].getText()) &&
                buttons[line[1]].getText().equals(buttons[line[2]].getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (JButton btn : buttons) {
            if (btn.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean isGameOver() {
        String status = statusLabel.getText();
        return status.startsWith("The winner is:") || status.equals("Game ended in a draw.");
    }

    private void disableButtons() {
        for (JButton btn : buttons) {
            btn.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGUI());
    }
}


