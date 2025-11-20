package skillbuilders;
import java.io.*;
import java.util.*;
public class Roster {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       ArrayList<StuName> students = new ArrayList<>();
       try {
           // Prompt for file name
           System.out.print("Enter the file name to store student names (e.g., roster.txt): ");
           String fileName = input.nextLine().trim();
           // Automatically add .txt if not present
           if (!fileName.endsWith(".txt")) {
               fileName += ".txt";
           }
           // ✅ Save file inside SkillBuilders package (src/SkillBuilders/)
           String packagePath = System.getProperty("user.dir")
                   + File.separator + "src"
                   + File.separator + "SkillBuilders"
                   + File.separator + fileName;
           File file = new File(packagePath);
           // Prompt for number of students
           System.out.print("Enter the number of students in the class: ");
           int numStudents = Integer.parseInt(input.nextLine().trim());
           // Collect student info
           for (int i = 1; i <= numStudents; i++) {
               System.out.println("\nEnter information for student " + i + ":");
               System.out.print("First name: ");
               String first = input.nextLine().trim();
               System.out.print("Last name: ");
               String last = input.nextLine().trim();
               students.add(new StuName(first, last));
           }
           // ✅ Write data to file
           try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
               for (StuName s : students) {
                   writer.println(s);
               }
           }
           // ✅ Confirm where it was saved
           System.out.println("\nClass roster has been saved to:");
           System.out.println(file.getAbsolutePath());
           // ✅ Read and display the roster
           System.out.println("\nDisplaying class roster:");
           System.out.println("---------------------------");
           try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
               String line;
               while ((line = reader.readLine()) != null) {
                   System.out.println(line);
               }
           }
       } catch (IOException e) {
           System.out.println("Error writing or reading file: " + e.getMessage());
       } catch (NumberFormatException e) {
           System.out.println("Invalid number. Please enter an integer.");
       } finally {
           input.close();
       }
   }
}
