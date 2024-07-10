package avivFadlunRoeiDuenyas;

public class Product {
    public enum Catagoryenum { KIDS , ELECTRICITY, OFFICE, CLOTH }
    private int id;
    private String name;
    private double price;
    public Boolean optionSpecialPackaging;
    private boolean SpecialPackaging;
    private Catagoryenum catagoryenum;

    // Constructor
    public Product(int id ,String name, double price, Boolean optionSpecialPackaging, Catagoryenum catagoryenum) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.optionSpecialPackaging = optionSpecialPackaging;
        this.catagoryenum = catagoryenum;
    }

    public void setSpecialPackaging(boolean specialPackaging) {
        SpecialPackaging = specialPackaging;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Catagoryenum getProductCatagory() {
        return catagoryenum;
    }

    public boolean getOptionSpecialPackaging() {
        return optionSpecialPackaging;
    }

    // toString method
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id + ", optionSpecialPackaging=" + optionSpecialPackaging + " ,productCatagory=" + catagoryenum +
                ", SpecialPackaging=" + SpecialPackaging +'}';
    }

}
