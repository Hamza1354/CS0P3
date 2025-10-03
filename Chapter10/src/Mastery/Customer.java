package Mastery;
public class Customer {
   private String firstName, lastName;
   public Customer(String fName, String lName) {
       firstName = fName;
       lastName = lName;
   }
   @Override
   public String toString() {
       return " " + firstName + " " + lastName + " ";
   }
}

