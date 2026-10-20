
import java.util.HashMap;
import java.util.Scanner;

public class BankDirectory {
    HashMap<Integer, String> accounts = new HashMap<>();

    void addAccount(int number, String name) {
        accounts.put(number, name);
        System.out.println("Account added successfully.");
    }

    void getCustomer(int number) {
        if (accounts.containsKey(number))
            System.out.println("Account No: " + number +
                    " -> " + accounts.get(number));
        else
            System.out.println("Account not found.");
    }

    void displayAll() {
        System.out.println("All Accounts: " + accounts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankDirectory b = new BankDirectory();

        while (true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int no = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    b.addAccount(no, name);
                    break;
                case 2:
                    System.out.print("Enter Account No: ");
                    b.getCustomer(sc.nextInt());
                    break;
                case 3:
                    b.displayAll();
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}