package Classwork_Task_6_ООП;

public class Product {

    private String name;
    private double price;
    private String category;
    private boolean inStock; // по факту, это     quantity != 0
    private int quantity;

    public Product(String name, double price, String category, boolean inStock, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        this.quantity = quantity;
    }

    public Product(String name, double price, String category) {
        this(name, price, category, false, 0);
    }

    public Product() {
        this("товар", 0, "категория");
    }

    public String displayInfo() {
        return name + '_' + price + '_' + quantity;
    }

    public double applyDiscount(double percent) {
        return price / 100 * (100 - percent);
    }

    public void restock(int amount) {
        quantity += amount;
        inStock = quantity != 0;
    }

    public void sell(int amount) {
        assert quantity >= amount;
        quantity -= amount;
        System.out.println("продано " + name + " на " + (price * amount));
    }

}
