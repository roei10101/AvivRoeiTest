import java.util.Scanner;

public class Main {
    private static Manager manager = new Manager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
         //   scanner.next(); // consume newline
            switch (choice) {
                case 1 -> addSeller();
                case 2 -> addBuyer();
                case 3 -> addProductToSeller();
                case 4 -> addProductToBuyerCart();
                case 5 -> checkoutBuyerCart();
                case 6 -> displaySellers();
                case 7 -> displayBuyers();
                case 8 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting...");
    }

    private static void printMenu() {
        System.out.println("1. Add Seller");
        System.out.println("2. Add Buyer");
        System.out.println("3. Add Product to Seller");
        System.out.println("4. Add Product to Buyer Cart");
        System.out.println("5. Checkout Buyer Cart");
        System.out.println("6. Display Sellers");
        System.out.println("7. Display Buyers");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addSeller() {
        System.out.print("Enter seller name: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        if (manager.addSeller(username, password)) {
            System.out.println("Seller added successfully.");
        } else {
            System.out.println("Username is already taken. Please try a different username.");
            addSeller();
        }
    }

    private static void addBuyer() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Enter address: ");
        String address = scanner.next();
        if (manager.addBuyer(username, password,address)) {
            System.out.println("Buyer added successfully.");
        } else {
            System.out.println("Username is already taken. Please try a different username.");
            addBuyer();
        }
    }

    private static void addProductToSeller() {
        System.out.print("Enter seller's username: ");
        String sellerUsername = scanner.next();
        System.out.print("Enter product name: ");
        String productName = scanner.next();
        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        //scanner.next(); // consume newline
        if (manager.addProductToSeller(sellerUsername, productName, productPrice)) {
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Seller not found.");
        }
    }

    private static void addProductToBuyerCart() {
        System.out.print("Enter buyer's username: ");
        String buyerUsername = scanner.next();
        System.out.print("Enter seller's username: ");
        String sellerUsername = scanner.next();
        manager.displaySellerProducts(sellerUsername);

        System.out.print("Enter product name: ");
        String productName = scanner.next();
        if (manager.addProductToBuyerCart(buyerUsername, sellerUsername, productName)) {
            System.out.println("Product added to cart successfully.");
        } else {
            System.out.println("Buyer or Seller or Product not found.");
        }
    }

    private static void checkoutBuyerCart() {
        System.out.print("Enter buyer's username: ");
        String buyerUsername = scanner.next();
        manager.checkoutBuyerCart(buyerUsername);
    }

    private static void displaySellers() {
        manager.displaySellers();
    }

    private static void displayBuyers() {
        manager.displayBuyers();
    }
}
