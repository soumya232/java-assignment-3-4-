import java.util.Scanner;

public class AverageGrade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks of subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            sum += marks[i];
        }

        double average = sum / 5.0;

        System.out.println("Average = " + average);

        if (average >= 90) {
            System.out.println("Grade: A");
        } else if (average >= 75) {
            System.out.println("Grade: B");
        } else if (average >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }

        sc.close();
    }
}