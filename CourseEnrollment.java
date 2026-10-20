
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CourseEnrollment {
    LinkedHashSet<String> students = new LinkedHashSet<>();

    void enrollStudent(String name) {
        if (students.add(name))
            System.out.println("Enrolled: " + name);
        else
            System.out.println(name + " is already enrolled");
    }

    void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment c = new CourseEnrollment();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enroll: ");
            c.enrollStudent(sc.nextLine());
        }

        c.displayEnrolledStudents();
        sc.close();
    }
}