
import java.util.HashSet;
import java.util.Scanner;

public class Attendance {
    HashSet<String> students = new HashSet<>();

    void markAttendance(String name) {
        if (students.add(name))
            System.out.println("Attendance marked for " + name);
        else
            System.out.println(name + " is already marked present");
    }

    void displayAttendance() {
        System.out.println("Present Students: " + students);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance a = new Attendance();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name to mark attendance: ");
            a.markAttendance(sc.nextLine());
        }

        a.displayAttendance();
        sc.close();
    }
}
