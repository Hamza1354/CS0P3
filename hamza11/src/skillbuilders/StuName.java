package skillbuilders;
public class StuName {
   private String firstName;
   private String lastName;
   /**
    * Constructor
    * pre: none
    * post: StuName object has been created with given names.
    */
   public StuName(String first, String last) {
       this.firstName = first;
       this.lastName = last;
   }
   /**
    * Returns a string representation of the student's full name.
    * pre: none
    * post: Student name has been returned as a String.
    */
   public String toString() {
       return firstName + " " + lastName;
   }
}
