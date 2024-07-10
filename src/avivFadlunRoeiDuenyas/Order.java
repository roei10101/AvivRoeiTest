package avivFadlunRoeiDuenyas;

import java.util.Date;

public class Order {
    private Product[] products;
    private double[] prices;
    private Date orderDate;
    private double total;
    private String buyerUsername;

    // Constructor
    public Order(Product[] products, double[] prices, Date orderDate, double total, String buyerUsername) {
        this.products = products;
        this.prices = prices;
        this.orderDate = orderDate;
        this.total = total;
        this.buyerUsername = buyerUsername;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("orderDate=").append(orderDate);
        sb.append(", total=").append(total);
        sb.append(", buyerUsername='").append(buyerUsername).append('\'');
        sb.append(", products=");
        for (int i = 0; i < products.length; i++) {
            sb.append("\n\t").append(products[i].getName()).append(" - $").append(prices[i]);
        }
        sb.append('}');
        return sb.toString();
    }
}
