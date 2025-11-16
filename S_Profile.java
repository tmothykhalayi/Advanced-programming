//Student Bio Profile

import java.util.Scanner;
public class S_Profile {
    private String name ;
    private String RegistrationNumber ;
    private int yearOfStudy ;
    private String StudentEmail;
    private double gpa;
    private String courseEnrolled;

 public S_Profile(String name, String RegistrationNumber, int yearOfStudy, double gpa, String courseEnrolled, String StudentEmail) {
    this.name = name;
    this.RegistrationNumber = RegistrationNumber;
    this.yearOfStudy = yearOfStudy;
    this.StudentEmail = StudentEmail;
    this.gpa = gpa;
    this.courseEnrolled = courseEnrolled;
 }

 public String getName() {
        return name;
    }
    public String getRegNo() {
        return RegistrationNumber;
    }
    public String getEmail() {
        return StudentEmail;
    }
    public int getyearofstudy() {
        return yearOfStudy;
    }
    public double getGpa() {
        return gpa;
    }
    public String getCourseEnrolled() {
        return courseEnrolled;
    }


    public void printProfile(){
          System.out.println("-------- Student Profile --------");
        System.out.println("Name       : " + name);
        System.out.println("Reg. No    : " + RegistrationNumber);
        System.out.println("Email      : " + StudentEmail);
        System.out.println("Year       : " + yearOfStudy);
        System.out.println("GPA        : " + gpa);
        System.out.println("Course     : " + courseEnrolled);
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S_Profile s1 = new S_Profile("Timothy Khalayi Manya", "CT100/G/18419/23", 3,  3.9 , "Computer Science", "timothy.khalayi@gmail.com");
        s1.printProfile();
        


        System.out.println("\n--- Enter a new student's details ---");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Registration Number: ");
        String regNo = sc.nextLine();
        System.out.print("Year of Study: ");
        int year = sc.nextInt();
        System.out.print("GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Course Enrolled: ");
        String course = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        S_Profile s2 = new S_Profile(name, regNo, year, gpa, course, email);
        s2.printProfile();

        sc.close();
    }

}