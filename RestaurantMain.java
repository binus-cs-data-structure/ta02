import java.util.Scanner;
/**
 * Main class untuk menjalankan Restaurant Queue Management System
 */
public class RestaurantMain {
    
    public static void main(String[] args) {
        RestaurantQueue queue = new RestaurantQueue();
        try (Scanner scanner = new Scanner(System.in)) {
            interactiveMenu(queue, scanner);
        }
    }
    
    
    /**
     * Menampilkan UI action untuk user
     */
    private static void interactiveMenu(RestaurantQueue queue, Scanner scanner) {
        int choice;
        System.out.println("=== Restaurant Queue Management System ===");
        System.out.println("Using Single Linked List Implementation");
        System.out.println("TA02 - Data Structures and Algorithm Analysis\n");
        System.out.println("============================================\n");
        
        do {
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Queue");
            System.out.println("4. Peek Next Customer");
            System.out.println("5. Exit");
            System.out.print("Choose option (1-5): ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1; // Pilihan tidak valid
            }
            
            switch (choice) {
                case 1:
                    addCustomer(queue, scanner);
                    break;
                case 2:
                    queue.pop();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    Customer nextCustomer = queue.peek();
                    if (nextCustomer != null) {
                        System.out.println("Next customer to be served: " + nextCustomer);
                    } else {
                        System.out.println("No customers in queue");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using Restaurant Queue Management System!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-5");
            }
            System.out.println();
        } while (choice != 5);
    }
    
    /**
     * Add customer interactively with input validation
     * Customer ID is auto-generated for uniqueness and simplicity
     */
    private static void addCustomer(RestaurantQueue queue, Scanner scanner) {
        try {
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("Customer name cannot be empty!");
                return;
            }
            
            Customer customer = new Customer(name);
            queue.push(customer);
            
        } catch (Exception e) {
            System.out.println("Error adding customer: " + e.getMessage());
            scanner.nextLine();
        }
    }
} 