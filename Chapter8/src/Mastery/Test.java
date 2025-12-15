package Mastery;
import java.util.Scanner;
public class Test {
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       UEmployee[] employees = new UEmployee[3];
       for (int i = 0; i < employees.length; i++) {
           System.out.println("\nEnter employee name");
           String name = in.nextLine();
           System.out.println("Enter employee salary");
           double salary = in.nextDouble();
           in.nextLine(); // clear leftover newline[web:14]
           System.out.println("Are they faculty or staff? (1 = Faculty, 2 = Staff)");
           int choice = in.nextInt();
           in.nextLine(); // clear leftover newline
           if (choice == 1) {
               System.out.println("Enter Department/Faculty:");
               String dept = in.nextLine();
               employees[i] = new Faculty(name, salary, dept);
           } else {
               System.out.println("Enter employee title:");
               String title = in.nextLine();
               employees[i] = new Staff(name, salary, title);
           }
       }
       System.out.println("\nUniversity Employees:");
       for (UEmployee e : employees) {
           if (e instanceof Faculty) {
               Faculty f = (Faculty) e;
               System.out.println(f.getName() + "  " +
                                  f.getDepartment() + "  " +
                                  f.getSalary());
           } else if (e instanceof Staff) {
               Staff s = (Staff) e;
               System.out.println(s.getName() + "  " +
                                  s.getJobTitle() + "  " +
                                  s.getSalary());
           }
       }
       in.close();
   }
}

