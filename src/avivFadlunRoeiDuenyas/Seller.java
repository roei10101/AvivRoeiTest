package avivFadlunRoeiDuenyas;

public class Seller extends Person {
    private Product[] products;
    private int productCount;


    // Constructor
    public Seller(String username, String password) {
        super(username,password);
        this.products = new Product[2]; // initial capacity
        this.productCount = 0;

    }

    // Getters
    public String getUsername() {
        return username;
    }


    public Product[] getProducts() {
        Product[] currentProducts = new Product[productCount];
        for (int i = 0; i < productCount; i++) {
            currentProducts[i] = products[i];
        }
        return currentProducts;
    }

    // Add product
    public void addProduct(Product product) {
        if (productCount == products.length) {
            resizeProducts();
        }
        products[productCount++] = product;
    }

    // Resize products array
    private void resizeProducts() {
        Product[] newProducts = new Product[products.length * 2];
        for (int i = 0; i < products.length; i++) {
            newProducts[i] = products[i];
        }
        products = newProducts;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seller{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", products=");
        for (int i = 0; i < productCount; i++) {
            sb.append("\n\t").append(products[i]);
        }
        sb.append('}');
        return sb.toString();
    }
}
