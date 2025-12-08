package Mastery;

public class test {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Dr. Smith", 75000, "Computer Science");
        Staff staff = new Staff("Jane Doe", 50000, "Administrator");

        System.out.println("Faculty: " + faculty.getName() + ", Dept: " + faculty.getDepartment() + ", Salary: " + faculty.getSalary());
        System.out.println("Staff: " + staff.getName() + ", Job Title: " + staff.getJobTitle() + ", Salary: " + staff.getSalary());
    }
}
