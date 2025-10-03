package Mastery;
import javax.swing.*;
import java.awt.*;
public class localbank extends JFrame {
   private static final long serialVersionUID = 1L;
   private JComboBox<String> actionCombo;
   private JTextField accountField, amountField, firstNameField, lastNameField, balanceField;
   private JLabel displayLabel;
   private JLabel accountLabel, amountLabel, firstNameLabel, lastNameLabel, balanceLabel;
   private Bank bank;
   private Color defaultLabelColor;
   public localbank() {
       initialize();
   }
   private void initialize() {
       setTitle("LocalBankGUI");
       setBounds(100, 100, 494, 571);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       getContentPane().setLayout(null);
       bank = new Bank();
       actionCombo = new JComboBox<>();
       actionCombo.setModel(new DefaultComboBoxModel<>(
           new String[]{"Deposit", "Withdraw", "Add Account", "Delete Account", "Check Balance"}));
       actionCombo.setBounds(27, 45, 426, 30);
       getContentPane().add(actionCombo);
       accountLabel = new JLabel("Account ID:");
       accountLabel.setBounds(27, 109, 138, 14);
       getContentPane().add(accountLabel);
       accountField = new JTextField();
       accountField.setBounds(27, 123, 426, 30);
       getContentPane().add(accountField);
       amountLabel = new JLabel("Amount of deposit/withdrawal:");
       amountLabel.setBounds(27, 164, 200, 14);
       getContentPane().add(amountLabel);
       amountField = new JTextField();
       amountField.setBounds(27, 179, 426, 30);
       getContentPane().add(amountField);
       firstNameLabel = new JLabel("First Name:");
       firstNameLabel.setBounds(27, 215, 174, 14);
       getContentPane().add(firstNameLabel);
       firstNameField = new JTextField();
       firstNameField.setBounds(27, 229, 426, 30);
       getContentPane().add(firstNameField);
       lastNameLabel = new JLabel("Last Name:");
       lastNameLabel.setBounds(27, 271, 208, 14);
       getContentPane().add(lastNameLabel);
       lastNameField = new JTextField();
       lastNameField.setBounds(27, 285, 426, 30);
       getContentPane().add(lastNameField);
       balanceLabel = new JLabel("Beginning Balance:");
       balanceLabel.setBounds(27, 326, 119, 14);
       getContentPane().add(balanceLabel);
       balanceField = new JTextField();
       balanceField.setBounds(27, 342, 426, 30);
       getContentPane().add(balanceField);
       displayLabel = new JLabel("Account Info Displayed Here:");
       displayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
       displayLabel.setBounds(52, 410, 400, 30);
       getContentPane().add(displayLabel);
       JButton processButton = new JButton("Process Transaction");
       processButton.setBounds(40, 459, 271, 39);
       getContentPane().add(processButton);
       defaultLabelColor = accountLabel.getForeground();
       // Proper listeners
       actionCombo.addItemListener(e -> {
           updateLabelColors();
           clearFields();
       });
       processButton.addActionListener(e -> processTransaction());
       updateLabelColors();
   }
   private void clearFields() {
       accountField.setText("");
       amountField.setText("");
       firstNameField.setText("");
       lastNameField.setText("");
       balanceField.setText("");
       displayLabel.setText("Account Info Displayed Here:");
   }
   private void updateLabelColors() {
       Color highlightColor = Color.RED;
       Color normalColor = defaultLabelColor;
       String action = (String) actionCombo.getSelectedItem();
       accountLabel.setForeground(normalColor);
       amountLabel.setForeground(normalColor);
       firstNameLabel.setForeground(normalColor);
       lastNameLabel.setForeground(normalColor);
       balanceLabel.setForeground(normalColor);
       switch (action) {
           case "Deposit":
           case "Withdraw":
               accountLabel.setForeground(highlightColor);
               amountLabel.setForeground(highlightColor);
               break;
           case "Add Account":
               firstNameLabel.setForeground(highlightColor);
               lastNameLabel.setForeground(highlightColor);
               balanceLabel.setForeground(highlightColor);
               break;
           case "Delete Account":
           case "Check Balance":
               accountLabel.setForeground(highlightColor);
               break;
       }
   }
   private void processTransaction() {
       String action = (String) actionCombo.getSelectedItem();
       String acctID = accountField.getText().trim();
       String firstName = firstNameField.getText().trim();
       String lastName = lastNameField.getText().trim();
       String balanceStr = balanceField.getText().trim();
       String amountStr = amountField.getText().trim();
       try {
           switch (action) {
               case "Add Account":
                   if (firstName.isEmpty() || lastName.isEmpty()) {
                       displayLabel.setText("First and Last names are required");
                       return;
                   }
                   if (balanceStr.isEmpty()) {
                       displayLabel.setText("Enter a valid beginning balance");
                       return;
                   }
                   double startingBalance;
                   try {
                       startingBalance = Double.parseDouble(balanceStr);
                   } catch (NumberFormatException e) {
                       displayLabel.setText("Enter a valid number for beginning balance");
                       return;
                   }
                   if (startingBalance < 0) {
                       displayLabel.setText("Balance cannot be negative");
                       return;
                   }
                   acctID = bank.addAccount(firstName, lastName, startingBalance);
                   if (acctID == null) {
                       displayLabel.setText("Account exists for that name!");
                       return;
                   }
                   displayLabel.setText("<html>Account added!<br>Account ID: " + acctID +
                       "<br>Name: " + firstName + " " + lastName +
                       "<br>Balance: $" + String.format("%.2f", startingBalance) + "</html>");
                   return;
               case "Delete Account":
                   boolean deleted = bank.deleteAccount(acctID);
                   displayLabel.setText(deleted ? "Account " + acctID + " deleted" : "Account not found");
                   return;
               case "Check Balance":
                   Double balance = bank.getAccountBalance(acctID);
                   if (balance == null) {
                       displayLabel.setText("Account not found");
                   } else {
                       displayLabel.setText("Balance: $" + String.format("%.2f", balance));
                   }
                   return;
               case "Deposit":
               case "Withdraw":
                   if (amountStr.isEmpty()) {
                       displayLabel.setText("Enter a valid amount");
                       return;
                   }
                   double amount;
                   try {
                       amount = Double.parseDouble(amountStr);
                   } catch (NumberFormatException e) {
                       displayLabel.setText("Enter a valid number for amount");
                       return;
                   }
                   if (amount <= 0) {
                       displayLabel.setText("Amount must be positive");
                       return;
                   }
                   Double currentBalance = bank.getAccountBalance(acctID);
                   if (currentBalance == null) {
                       displayLabel.setText("Account not found");
                       return;
                   }
                   if ("Withdraw".equals(action) && currentBalance < amount) {
                       displayLabel.setText("Insufficient funds");
                       return;
                   }
                   int transCode = action.equals("Deposit") ? 1 : 2;
                   String result = bank.transaction(transCode, acctID, amount);
                   displayLabel.setText("<html>" + result + "</html>");
                   return;
               default:
                   displayLabel.setText("Unknown action");
                   return;
           }
       } catch (Exception ex) {
           displayLabel.setText("An unexpected error occurred");
       }
   }
   public static void main(String[] args) {
       EventQueue.invokeLater(() -> {
           new localbank().setVisible(true);
       });
   }
}

