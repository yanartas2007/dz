package SEM1.Homework_ООП_3.Task2;

public abstract class MenuItem {
    private String itemId;
    private String name;
    private double price;
    private int cookingTime;
    private boolean isAvailable;

    private static int totalMenuItems = 0;
    private static final int MAX_COOKING_TIME = 120;

    public MenuItem(String itemId, String name, double price, int cookingTime, boolean isAvailable) {
        setItemId(itemId);
        setName(name);
        setPrice(price);
        setCookingTime(cookingTime);
        setIsAvailable(isAvailable);
        totalMenuItems++;
    }

    public MenuItem(String itemId, String name, double price) {
        this(itemId, name, price, 0, false);
    }

    public MenuItem() {
        this("NO_ID", "NO_NAME", 0);
    }

    public abstract String getItemType();

    public abstract void prepare();

    public String displayInfo() {
        return name + " " + price + " " + isAvailable;
    }

    public void updatePrice(double newPrice) {
        setPrice(newPrice);
    }


    public static int getTotalMenuItems() {
        return totalMenuItems;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        assert itemId.length() > 0;
        this.itemId = itemId;
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
        assert price >= 0;
        this.price = price;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        assert cookingTime >= 1 && cookingTime <= MAX_COOKING_TIME;
        this.cookingTime = cookingTime;
    }

    public boolean GetIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }
}
