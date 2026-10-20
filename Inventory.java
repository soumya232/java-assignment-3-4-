
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    HashMap<Integer, Integer> stock = new HashMap<>();

    void addProduct(int id, int quantity) {
        stock.put(id, quantity);
        System.out.println("Product " + id +
                " added with stock " + quantity);
    }

    void updateStock(int id, int quantity) {
        if (stock.containsKey(id)) {
            stock.put(id, quantity);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void displayInventory() {
        Iterator<Map.Entry<Integer, Integer>> it =
                stock.entrySet().iterator();

        System.out.println("Product ID - Stock");
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> item = it.next();
            System.out.println(item.getKey() + " - "
                    + item.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Stock: ");
                    int qty = sc.nextInt();
                    inv.addProduct(id, qty);
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter New Stock: ");
                    qty = sc.nextInt();
                    inv.updateStock(id, qty);
                    break;
                case 3:
                    inv.displayInventory();
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