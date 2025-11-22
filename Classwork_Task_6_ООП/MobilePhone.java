package Classwork_Task_6_ООП;

public class MobilePhone {

    private String brand;
    private String model;
    private int storageGB;
    private int batteryLevel;
    private boolean isPoweredOn;

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

    public String displayInfo() {
        return brand + '_' + model;
    }

    public void powerOn() {
        isPoweredOn = true;
    }

    public void powerOff() {
        isPoweredOn = false;
    }

    public void chargeBattery() {
        batteryLevel = 100;
    }

    public void useBattery() {
        batteryLevel = 0;
    }
}
