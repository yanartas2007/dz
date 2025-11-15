package domashka7_OOP;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private boolean isRunning;
    private double mileage;


    public Car(String brand, String model, int year, String color, double price, boolean isRunning, double mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.isRunning = isRunning;
        this.mileage = mileage;
    }

    public Car(String brand, String model, int year) {
        this(brand, model, year, "цвет", 0.0, false, 0);
    }

    public Car() {
        this("какаятомарка", "какаятомодель", 0);
    }

    public String displayInfo() {
        return model + '_' + mileage;
    }

    public void startEngine() {
        isRunning = true;
    }

    public void stopEngine() {
        isRunning = false;
    }

    public void drive(double distance) {
        mileage += distance;
    }

    public void repaint(String newColor) {
        color = newColor;
    }

    public void updatePrice(double newPrice) {
        price = newPrice;
    }
}
