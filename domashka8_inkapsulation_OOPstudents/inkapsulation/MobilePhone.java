package domashka8_inkapsulation_OOPstudents.inkapsulation;

public class MobilePhone {

    private String brand;
    private String model;
    private int storageGB;
    private int batteryLevel;
    private boolean isPoweredOn;
    private static int totalPhones = 0;
    private final int MAX_BATTERY = 100;

    public MobilePhone(String brand, String model, int storageGB, int batteryLevel, boolean isPoweredOn) {
        this.brand = brand;
        this.model = model;
        this.storageGB = storageGB;
        this.batteryLevel = batteryLevel;
        this.isPoweredOn = isPoweredOn;
    }

    public MobilePhone(String brand, String model, int storageGB) {
        this(brand, model, storageGB, 0, false);
    }

    public MobilePhone() {
        this("какаятомарка", "какаятомодель", 0);
    }

    public static void displayTechSupport() {
        System.out.println("Похоже, это не гарантийный случай. С уважением, техподдержка");
    }

    public String displayInfo() {
        return brand + '_' + model;
    }

    public String displayInfo(boolean showPowerStatus) {
        if (showPowerStatus) {return brand + '_' + model + '_' + batteryLevel;} else
        {return brand + '_' + model;}
    }

    public void powerOn() {
        isPoweredOn = true;
    }

    public void powerOff() {
        isPoweredOn = false;
    }

    public void chargeBattery(int percent) {
        batteryLevel += percent;
    }

    public void chargeBattery(int percent, String minutes) {
        chargeBattery(percent);
        System.out.println(minutes);
    }

    public void useBattery(int percent) {
        batteryLevel -= percent;
    }

    public void useBattery(int percent, String appName) {
        batteryLevel -= percent;
        System.out.println(appName);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        assert batteryLevel < 101 && batteryLevel > 0;
        this.batteryLevel = batteryLevel;
    }

    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    public void setPoweredOn(boolean poweredOn) {
        isPoweredOn = poweredOn;
    }
}
