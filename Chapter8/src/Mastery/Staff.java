package Mastery;

public class Staff extends UEmployee {
    private String jobTitle;

    public Staff(String name, double salary, String jobTitle) {
        super(name, salary);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
