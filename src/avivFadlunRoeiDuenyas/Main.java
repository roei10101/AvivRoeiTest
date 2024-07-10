/*
RoeiDuenyas - 212214514 pini shalomi
AvivFadlun - 324186279 pini shalomi
 */
package avivFadlunRoeiDuenyas;
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
                case 8 -> displaycatagory();
                case 9 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
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
        System.out.println("8. Display Buyers by catagory");
        System.out.println("9. Exit");
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
        manager.displaycCatagory();
        System.out.print("Enter product catagory: ");
        Product.Catagoryenum productCatagory = Product.Catagoryenum.valueOf(scanner.next());
        System.out.print("do you want special packaging:(true,false) ");
        boolean optionspecialPackaging = scanner.nextBoolean();
        if (manager.addProductToSeller(sellerUsername, productName, productPrice, optionspecialPackaging , productCatagory)) {
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
        boolean specialPackaging = false;
        if (manager.isOptionSpecialPackaging(sellerUsername , productName)) {
            System.out.print("do you want special packaging:(true,false)");
            specialPackaging = scanner.nextBoolean();
        }
        if (manager.addProductToBuyerCart(buyerUsername, sellerUsername, productName, specialPackaging)) {
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
    private static void displaycatagory() {
        manager.displaycCatagory();
        Product.Catagoryenum choice = Product.Catagoryenum.valueOf(scanner.next());
        manager.printProductByCatagory(choice);
    }
}
