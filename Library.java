
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<String> books = new ArrayList<>();

    void addBook(String name) {
        books.add(name);
        System.out.println("Book added successfully.");
    }

    void removeBook(String name) {
        if (books.remove(name))
            System.out.println("Book removed successfully.");
        else
            System.out.println("Book not found.");
    }

    void displayBooks() {
        System.out.println("Current Books:");
        for (String book : books)
            System.out.println(book);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    lib.addBook(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    lib.removeBook(sc.nextLine());
                    break;
                case 3:
                    lib.displayBooks();
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
