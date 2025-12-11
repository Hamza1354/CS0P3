package Mastery;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        UEmployee[] employees = new UEmployee[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");

            System.out.print("Employee name: ");
            String name = in.nextLine();

            System.out.print("Employee title (department or job title): ");
            String titleOrDept = in.nextLine();

            System.out.print("Employee salary: ");
            double salary = in.nextDouble();
            in.nextLine(); // clear newline

            System.out.print("Type 1 for Faculty, 2 for Staff: ");
            int choice = in.nextInt();
            in.nextLine(); // clear newline

            if (choice == 1) {
                employees[i] = new Faculty(name, salary, titleOrDept);
            } else {
                employees[i] = new Staff(name, salary, titleOrDept);
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
