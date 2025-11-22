package Classwork_Инкапсуляция;

public class Product {

    private String name;
    private double price;
    private String category;
    private boolean inStock; // по факту, это     quantity != 0
    private int quantity;
    private static int totalProducts = 0;
    private final String STORE_NAME = "Супермаркет 'У дома'";

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

    public static double calculateTotalValue(Product[] products) {
        double total = 0;
        for (Product i: products) {total += i.price;}
        return total;
    }

    public String displayInfo() {
        return name + '_' + price + '_' + quantity;
    }

    public String displayInfo(boolean showStockStatus) {
        if (showStockStatus) {System.out.println(inStock);}
        return name + '_' + price + '_' + quantity;
    }

    public double applyDiscount(double percent) {
        return price / 100 * (100 - percent);
    }

    public double applyDiscount(double percent, String promoCode) {
        System.out.println(promoCode);
        return price / 100 * (100 - percent);
    }

    public void restock(int amount) {
        quantity += amount;
        inStock = quantity != 0;
    }

    public void restock(int amount, String supplier) {
        quantity += amount;
        inStock = quantity != 0;
        System.out.println(supplier);
    }

    public void sell(int amount) {
        assert quantity >= amount;
        quantity -= amount;
        System.out.println("продано " + name + " на " + (price * amount));
    }

    public void sell(int amount, String customer) {
        assert quantity >= amount;
        quantity -= amount;
        System.out.println("продано " + name + " на " + (price * amount));
        System.out.println(customer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        assert price > 0 && price <= 1000000;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQuantity() {
        assert quantity > 0;
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
