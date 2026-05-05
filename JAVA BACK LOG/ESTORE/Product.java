package ESTORE;

public class Product {

    private String name;
    private String id;
    private double price;
    private String description;
    private ProductCategory category;

    public Product(String name, String productId, double price, String description) {
        this.name = name;
        this.id = productId;
        this.price = price;
        this.description = description;
    }

    public String getName() { return name;}
    public void setName(String name){this.name = name;}
    public void setPrice(double price) {this.price = price;}

}
