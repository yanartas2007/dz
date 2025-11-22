package Homework_ООП_3.Task1;

public abstract class SmartDevice {
    private String deviceId;
    private String deviceName;
    private String location;
    private boolean isPoweredOn;
    private double powerConsumption;

    private static int totalDevices = 0;
    private final int MAX_POWER_CONSUMPTION = 5000;

    public SmartDevice(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption) {
        setDeviceId(deviceId);
        setDeviceName(deviceName);
        setLocation(location);
        setIsPoweredOn(isPoweredOn);
        setPowerConsumption(powerConsumption);
        totalDevices++;
    }

    public SmartDevice(String deviceId, String deviceName, String location) {
        this(deviceId, deviceName, location, false, 0);
    }

    public SmartDevice() {
        this("NO_ID", "NO_NAME", "NO_LOCATION");
    }

    public abstract String getDeviceType();

    public abstract void performAction();

    public void turnOn() {
        setIsPoweredOn(true);
    }

    public void turnOff() {
        setIsPoweredOn(false);
    }

    public String getStatus() {
        return deviceName + deviceId + " " + isPoweredOn;
    }

    public static int getTotalDevices() {
        return totalDevices;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        assert powerConsumption > 1 && powerConsumption <= MAX_POWER_CONSUMPTION;
        this.powerConsumption = powerConsumption;
    }

    public boolean getIsPoweredOn() {
        return isPoweredOn;
    }

    public void setIsPoweredOn(boolean poweredOn) {
        isPoweredOn = poweredOn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getMAX_POWER_CONSUMPTION() {
        return MAX_POWER_CONSUMPTION;
    }
}
