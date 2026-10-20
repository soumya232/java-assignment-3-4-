import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Are you an Indian Citizen? (true/false): ");
        boolean citizen = sc.nextBoolean();

        if (age >= 18 && citizen) {
            System.out.println("Eligible to Vote");
        } else {
            System.out.println("Not Eligible to Vote");
        }

        sc.close();
    }
}