package Mastery;

public class Faculty extends UEmployee {
    private String department;

    public Faculty(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
