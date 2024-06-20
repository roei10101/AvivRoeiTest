import java.util.Date;

public class Buyer {
    private String username;
    private String password;
    private String address;
    private Product[] cart;
    private int cartCount;
    private Order[] orderHistory;
    private int orderCount;

    // Constructor
    public Buyer(String username, String password,String address) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.cart = new Product[2]; // initial capacity
        this.cartCount = 0;
        this.orderHistory = new Order[2]; // initial capacity
        this.orderCount = 0;
    }

    // Getters
    public String getUsername() {
        return username;
    }



    public Product[] getCart() {
        Product[] currentCart = new Product[cartCount];
        for (int i = 0; i < cartCount; i++) {
            currentCart[i] = cart[i];
        }
        return currentCart;
    }

    public Order[] getOrderHistory() {
        Order[] currentOrderHistory = new Order[orderCount];
        for (int i = 0; i < orderCount; i++) {
            currentOrderHistory[i] = orderHistory[i];
        }
        return currentOrderHistory;
    }

    // Add product to cart
    public void addToCart(Product product) {
        if (cartCount == cart.length) {
            resizeCart();
        }
        cart[cartCount++] = product;
    }

    // Resize cart array
    private void resizeCart() {
        Product[] newCart = new Product[cart.length * 2];
        for (int i = 0; i < cart.length; i++) {
            newCart[i] = cart[i];
        }
        cart = newCart;
    }

    // Checkout
    public void checkout() {
        if (cartCount == 0) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return;
        }
        double total = 0;
        double[] prices = new double[cartCount];
        System.out.println("Purchased items:");
        for (int i = 0; i < cartCount; i++) {
            System.out.println(cart[i]);
            prices[i] = cart[i].getPrice();
            total += cart[i].getPrice();
        }
        System.out.println("Total amount: $" + total);
        System.out.println("Buyer: " + username);
        System.out.println("Address: " + address);

        Product[] purchasedProducts = new Product[cartCount];
        for (int i = 0; i < cartCount; i++) {
            purchasedProducts[i] = cart[i];
        }
        if (orderCount == orderHistory.length) {
            resizeOrderHistory();
        }
        orderHistory[orderCount++] = new Order(purchasedProducts, prices, new Date(), total, username);
        cart = new Product[2]; // reset cart
        cartCount = 0;
        System.out.println("Checkout complete. Cart is now empty.");
    }

    // Resize order history array
    private void resizeOrderHistory() {
        Order[] newOrderHistory = new Order[orderHistory.length * 2];
        for (int i = 0; i < orderHistory.length; i++) {
            newOrderHistory[i] = orderHistory[i];
        }
        orderHistory = newOrderHistory;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Buyer{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", address='").append(address).append('\'');

        sb.append(", cart=");
        for (int i = 0; i < cartCount; i++) {
            sb.append("\n\t").append(cart[i]);
        }
        sb.append(", orderHistory=");
        for (int i = 0; i < orderCount; i++) {
            sb.append("\n\t").append(orderHistory[i]);
        }
        sb.append('}');
        return sb.toString();
    }
}
