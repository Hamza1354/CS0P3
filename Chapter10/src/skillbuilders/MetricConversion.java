package skillbuilders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MetricConversion extends JFrame implements ActionListener {

    private JComboBox<String> conversionOptions;
    private JLabel conversionFormula;

    public MetricConversion() {
        setTitle("Metric Conversion");
        setSize(417, 106);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Label prompt
        JLabel promptLabel = new JLabel("Select a conversion type:");
        promptLabel.setBounds(5, 13, 122, 14);
        getContentPane().add(promptLabel);

        // Combo box options
        String[] options = {
            "inches to centimeters",
            "feet to meters",
            "gallons to liters",
            "pounds to kilograms"
        };
        conversionOptions = new JComboBox<>(options);
        conversionOptions.setBounds(132, 10, 128, 20);
        conversionOptions.addActionListener(this);
        getContentPane().add(conversionOptions);

        // Label to show formula
        conversionFormula = new JLabel("1 inch = 2.54 centimeters");
        conversionFormula.setBounds(265, 5, 300, 30);
        conversionFormula.setPreferredSize(new Dimension(300, 30));
        getContentPane().add(conversionFormula);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = (String) conversionOptions.getSelectedItem();
        switch(selected) {
            case "inches to centimeters":
                conversionFormula.setText("1 inch = 2.54 centimeters");
                break;
            case "feet to meters":
                conversionFormula.setText("1 foot = 0.3048 meters");
                break;
            case "gallons to liters":
                conversionFormula.setText("1 gallon = 4.5461 liters");
                break;
            case "pounds to kilograms":
                conversionFormula.setText("1 pound = 0.4536 kilograms");
                break;
            default:
                conversionFormula.setText("");
        }
    }

    public static void main(String[] args) {
        new MetricConversion();
    }
}


