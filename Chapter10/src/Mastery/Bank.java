package Mastery;
import java.util.HashMap;
import java.util.Map;
class Bank {
   private Map<String, Account> accounts = new HashMap<>();
   private String generateAccountID(String firstName, String lastName) {
       return firstName.substring(0, 1).toUpperCase() + lastName;
   }
   public String addAccount(String firstName, String lastName, double startingBalance) {
       String acctID = generateAccountID(firstName, lastName);
       if (accounts.containsKey(acctID)) {
           return null; // duplicate
       }
       accounts.put(acctID, new Account(acctID, firstName, lastName, startingBalance));
       return acctID;
   }
   public boolean deleteAccount(String acctID) {
       return accounts.remove(acctID) != null;
   }
   public Double getAccountBalance(String acctID) {
       Account a = accounts.get(acctID);
       return (a != null) ? a.getBalance() : null;
   }
   public String transaction(int transCode, String acctID, double amount) {
       Account a = accounts.get(acctID);
       if (a == null) return "Account " + acctID + " not found.";
       if (transCode == 1) {
           a.deposit(amount);
           return "Deposited $" + String.format("%.2f", amount) +
                  "<br>New Balance: $" + String.format("%.2f", a.getBalance());
       } else if (transCode == 2) {
           if (a.withdrawal(amount)) {
               return "Withdrew $" + String.format("%.2f", amount) +
                      "<br>New Balance: $" + String.format("%.2f", a.getBalance());
           } else {
               return "Insufficient funds.";
           }
       }
       return "Invalid transaction.";
   }
}

