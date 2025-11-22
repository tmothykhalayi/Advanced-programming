import java.io.*;
import java.util.*;
// Student Class
class Student {
    private String name;
    private int[] marks = new int[5];
    private int total;
    private double average;
    private String grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks.clone();
        calculate();
    }

    public String getName() { return name; }
    public int[] getMarks() { return marks; }
    public int getTotal() { return total; }
    public double getAverage() { return average; }
    public String getGrade() { return grade; }

    // calculate totals, avg, grade
    public void calculate() {
        total = 0;
        for (int m : marks) total += m;
        average = total / 5.0;

        if (average >= 90) grade = "A+";
        else if (average >= 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";
    }

    public void setMarks(int[] newMarks) {
        this.marks = newMarks.clone();
        calculate();
    }

    public void printMarksheet() {
        System.out.println("\n===== MARKSHEET =====");
        System.out.println("Name: " + name);
        System.out.println("-----------------------");
        for (int i = 0; i < marks.length; i++)
            System.out.println("Unit " + (i + 1) + ": " + marks[i]);
        System.out.println("-----------------------");
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("=======================\n");
    }

    public String toCSV() {
        return name + "," + marks[0] + "," + marks[1] + "," + marks[2] + "," + marks[3] + "," + marks[4];
    }

    public static Student fromCSV(String line) {
        String[] p = line.split(",");
        String name = p[0];
        int[] marks = new int[5];
        for (int i = 1; i <= 5; i++) marks[i - 1] = Integer.parseInt(p[i]);
        return new Student(name, marks);
    }
}
// MarksheetManager Class
class MarksheetManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void editStudent(String name, int[] newMarks) {
        Student s = searchStudent(name);
        if (s != null) {
            s.setMarks(newMarks);
            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void deleteStudent(String name) {
        Student s = searchStudent(name);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public Student searchStudent(String name) {
        for (Student s : students)
            if (s.getName().equalsIgnoreCase(name))
                return s;
        return null;
    }

    public void printAll() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }
        for (Student s : students) {
            s.printMarksheet();
        }
    }

    public void printRankList() {
        if (students.isEmpty()) {
            System.out.println("\nNo students to rank.");
            return;
        }

        students.sort((s1, s2) -> s2.getTotal() - s1.getTotal());

        System.out.println("\n===== RANK LIST =====");
        int rank = 1;
        for (Student s : students) {
            System.out.println(rank + ". " + s.getName() + " - Total: " + s.getTotal() + " Avg: " + s.getAverage());
            rank++;
        }
        System.out.println("======================\n");
    }

    public ArrayList<Student> getAll() { return students; }

    public void load(ArrayList<Student> list) { students = list; }
}

// FileHandler Class
class FileHandler {
    private static final String FILE_NAME = "students.csv";

    public static void save(ArrayList<Student> students) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));
            for (Student s : students) pw.println(s.toCSV());
            pw.close();
            System.out.println("Data saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<Student> load() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return list;

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = br.readLine()) != null)
                list.add(Student.fromCSV(line));

            br.close();
            System.out.println("Data loaded successfully!");
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
        return list;
    }
}


// Main App (Menu System)
public class MarksheetSystem {

    public static int[] getMarks(Scanner sc) {
        int[] m = new int[5];
        for (int i = 0; i < 5; i++) {
            while (true) {
                System.out.print("Enter marks for Unit " + (i + 1) + " (0-100): ");
                int mark = sc.nextInt();
                if (mark >= 0 && mark <= 100) {
                    m[i] = mark;
                    break;
                }
                System.out.println("Invalid! Marks must be 0–100.");
            }
        }
        return m;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MarksheetManager manager = new MarksheetManager();

        // Load previous records
        manager.load(FileHandler.load());

        while (true) {
            System.out.println("\n======== MARKSHEET MANAGEMENT SYSTEM ========");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student Marks");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Rank List");
            System.out.println("7. Save to File");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    int[] marks = getMarks(sc);
                    manager.addStudent(new Student(name, marks));
                    System.out.println("Student added!");
                    break;

                case 2:
                    System.out.print("Enter student name to edit: ");
                    name = sc.nextLine();
                    marks = getMarks(sc);
                    manager.editStudent(name, marks);
                    break;

                case 3:
                    System.out.print("Enter student name to delete: ");
                    name = sc.nextLine();
                    manager.deleteStudent(name);
                    break;

                case 4:
                    System.out.print("Enter student name to search: ");
                    name = sc.nextLine();
                    Student s = manager.searchStudent(name);
                    if (s != null) s.printMarksheet();
                    else System.out.println("Not found.");
                    break;

                case 5:
                    manager.printAll();
                    break;

                case 6:
                    manager.printRankList();
                    break;

                case 7:
                    FileHandler.save(manager.getAll());
                    break;

                case 8:
                    System.out.println("Exiting...");
                    FileHandler.save(manager.getAll());
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
