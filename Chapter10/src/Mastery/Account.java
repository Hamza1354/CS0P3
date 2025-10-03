package Mastery;
import java.text.NumberFormat;
public class Account {
   private double balance;
   private Customer cust;
   private String acctID;
   public Account(String acctID, String fName, String lName, double bal) {
       this.acctID = acctID;
       this.cust = new Customer(fName, lName);
       this.balance = bal;
   }
   public String getID() {
       return acctID;
   }
   public double getBalance() {
       return balance;
   }
   public void deposit(double amt) {
       balance += amt;
   }
   public boolean withdrawal(double amt) {
       if (amt <= balance) {
           balance -= amt;
           return true;
       }
       return false;
   }
   @Override
   public boolean equals(Object acct) {
       if (acct == null || !(acct instanceof Account))
           return false;
       Account testAcct = (Account) acct;
       return acctID.equals(testAcct.acctID);
   }
   @Override
   public String toString() {
       NumberFormat money = NumberFormat.getCurrencyInstance();
       return acctID + " " + cust.toString() + " Current balance is " + money.format(balance);
   }
}

