package avivFadlunRoeiDuenyas;

import java.util.Scanner;

public class Manager {
    private Seller[] sellers;
    private int sellerCount;
    private Buyer[] buyers;
    private int buyerCount;
    private int ID = 0;
    private int id;

    public Manager() {
        sellers = new Seller[10]; // initial capacity
        sellerCount = 0;
        buyers = new Buyer[10]; // initial capacity
        buyerCount = 0;
    }

    public boolean addSeller(String username, String password) {
        if (isUsernameTaken(username)) {
            return false; // Username is already taken
        }
        if (sellerCount == sellers.length) {
            resizeSellers();
        }
        sellers[sellerCount++] = new Seller(username, password);
        return true;
    }

    public boolean addBuyer(String username, String password,String address) {
        if (isUsernameTaken(username)) {
            return false; // Username is already taken
        }
        if (buyerCount == buyers.length) {
            resizeBuyers();
        }
        buyers[buyerCount++] = new Buyer(username, password, address);
        return true;
    }

    public boolean addProductToSeller(String sellerUsername, String productName, double productPrice,
                                      boolean optionspecialPackaging, Product.Catagoryenum productCatagory) {
        for (int i = 0; i < sellerCount; i++) {
            if (sellers[i].getUsername().equals(sellerUsername)) {
                id = ++ID;
                sellers[i].addProduct(new Product(id, productName, productPrice, optionspecialPackaging, productCatagory));
                return true;
            }
        }
        return false; // Seller not found
    }

    public boolean addProductToBuyerCart(String buyerUsername, String sellerUsername, String productName, boolean specialPackaging) {
        Buyer buyer = null;
        for (int i = 0; i < buyerCount; i++) {
            if (buyers[i].getUsername().equals(buyerUsername)) {
                buyer = buyers[i];
                break;
            }
        }
        if (buyer == null) {
            return false; // Buyer not found
        }

        for (int i = 0; i < sellerCount; i++) {
            if (sellers[i].getUsername().equals(sellerUsername)) {
                for (Product product : sellers[i].getProducts()) {
                    if (product.getName().equals(productName)) {
                        product.setSpecialPackaging(specialPackaging);
                        buyer.addToCart(product);
                        return true;
                    }
                }
            }
        }
        return false; // Seller or product not found
    }

    public void checkoutBuyerCart(String buyerUsername) {
        for (int i = 0; i < buyerCount; i++) {
            if (buyers[i].getUsername().equals(buyerUsername)) {
                buyers[i].checkout();
                return;
            }
        }
        System.out.println("Buyer not found.");
    }

    private boolean isUsernameTaken(String username) {
        for (int i = 0; i < sellerCount; i++) {
            if (sellers[i].getUsername().equals(username)) {
                return true;
            }
        }
        for (int i = 0; i < buyerCount; i++) {
            if (buyers[i].getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void resizeSellers() {
        Seller[] newSellers = new Seller[sellers.length * 2];
        for (int i = 0; i < sellers.length; i++) {
            newSellers[i] = sellers[i];
        }
        sellers = newSellers;
    }

    private void resizeBuyers() {
        Buyer[] newBuyers = new Buyer[buyers.length * 2];
        for (int i = 0; i < buyers.length; i++) {
            newBuyers[i] = buyers[i];
        }
        buyers = newBuyers;
    }

    public void displaySellers() {
        System.out.println("Sellers:");
        for (int i = 0; i < sellerCount; i++) {
            System.out.println(sellers[i]);
        }
    }

    public void displayBuyers() {
        System.out.println("Buyers:");
        for (int i = 0; i < buyerCount; i++) {
            System.out.println(buyers[i]);
        }
    }
    public void displaySellerProducts(String sellerUsername) {
        for (Seller seller : sellers) {
            if (seller.getUsername().equals(sellerUsername)) {
                System.out.println("Products of " + sellerUsername + ":");
                for (Product product : seller.getProducts()) {
                    System.out.println(product);
                }
                return;
            }
        }
        System.out.println("Seller not found.");
    }
    public void displaycCatagory() {
        Scanner userInput =  new Scanner(System.in);
        System.out.println("choose the catagory:");
        for (int i = 0; i < Product.Catagoryenum.values().length ; i++) {
            System.out.println( i+1 + ". " + Product.Catagoryenum.values()[i]);
        }
    }
    public void printProductByCatagory(Product.Catagoryenum choice) {
        for (int i = 0; i < this.sellers.length; i++) {
            if (this.sellers[i] != null) {
                for (int j = 0; j < this.sellers[i].getProducts().length; j++) {
                    if (this.sellers[i].getProducts()[j].getProductCatagory().equals(choice)) {
                        System.out.println(this.sellers[i].getProducts()[j]);
                    }
                }
            }
        }
    }
    public boolean isOptionSpecialPackaging(String seller ,String productName) {
        for (int i = 0; i < sellers.length; i++) {
            for (int j = 0; j < sellers[i].getProducts().length; j++) {
                if (sellers[i].getUsername().equals(seller) && sellers[i].getProducts()[j].getName().equals(productName)) {
                    return sellers[i].getProducts()[j].getOptionSpecialPackaging();
                }
            }
        }
        return false;
    }
}

