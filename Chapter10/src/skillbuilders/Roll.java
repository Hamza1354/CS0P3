package skillbuilders;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.net.URL;
import java.awt.image.BufferedImage;  // <-- Added import

public class Roll implements ActionListener {
    JFrame frame;
    JPanel contentPane;
    JButton rollDice;
    JLabel dieFace1;
    JLabel dieFace2;
    Random rand;

    // Resource paths relative to the classpath
    String[] diceImagePaths = {
        "1.png",
        "2.png",
        "3.png",
        "4.png",
        "5.png",
        "7.png"
    };

    public Roll() {
        rand = new Random();
        frame = new JFrame("Roll Two Dice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(30, 144, 255));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        JPanel dicePanel = new JPanel();
        dicePanel.setBackground(new Color(30, 144, 255));
        dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.LINE_AXIS));
        dicePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon icon1 = loadIcon(diceImagePaths[0]);
        ImageIcon icon2 = loadIcon(diceImagePaths[0]);

        Image img1 = icon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        Image img2 = icon2.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        dieFace1 = new JLabel(new ImageIcon(img1));
        dieFace2 = new JLabel(new ImageIcon(img2));
        dieFace1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        dieFace2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        dicePanel.add(dieFace1);
        dicePanel.add(dieFace2);
        contentPane.add(dicePanel);

        rollDice = new JButton("Roll Dice");
        rollDice.setAlignmentX(Component.CENTER_ALIGNMENT);
        rollDice.setFont(new Font("Verdana", Font.BOLD, 18));
        rollDice.setForeground(Color.white);
        rollDice.setBackground(new Color(255, 69, 0));
        rollDice.setFocusPainted(false);
        rollDice.addActionListener(this);

        contentPane.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPane.add(rollDice);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private ImageIcon loadIcon(String fileName) {
        URL location = getClass().getResource(fileName);
        if (location == null) {
            System.err.println("Could not find image: " + fileName);
            BufferedImage fallback = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = fallback.createGraphics();
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(0, 0, 80, 80);
            g2.setColor(Color.DARK_GRAY);
            g2.drawRect(10, 10, 60, 60);
            g2.dispose();
            return new ImageIcon(fallback); // safe fallback
        }
        return new ImageIcon(location);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int roll1 = rand.nextInt(6);
        int roll2 = rand.nextInt(6);

        ImageIcon icon1 = loadIcon(diceImagePaths[roll1]);
        ImageIcon icon2 = loadIcon(diceImagePaths[roll2]);

        Image img1 = icon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        Image img2 = icon2.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        dieFace1.setIcon(new ImageIcon(img1));
        dieFace2.setIcon(new ImageIcon(img2));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Roll());
    }
}
