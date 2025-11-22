package Homework_ООП_3.Task1;

public class SmartThermostat extends SmartDevice{
    private double currentTemperature;
    private double targetTemperature;
    private String mode;

    public SmartThermostat(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption, double currentTemperature, double targetTemperature, String mode) {
        super(deviceId, deviceName, location, isPoweredOn, powerConsumption);
        setCurrentTemperature(currentTemperature);
        setTargetTemperature(targetTemperature);
        setMode(mode);
    }

    @Override
    public String getDeviceType() {
        return "Умный термостат";
    }

    @Override
    public void performAction() {
        System.out.println("Температура регулируется");
    }

    public void setTemperature(double temp) {
        setTargetTemperature(temp); // Не совсем уверен, нужно менять current или target
    }

    public void setTemperature(double temp, String mode) {
        setTemperature(temp);
        setMode(mode);
    }

    public String getEnergyReport() {
        return getDeviceName() + getDeviceType() + ": температура в " + getLocation() + " " + currentTemperature;
    }

    public void scheduleTemperature(double temp, int hour) {
        double oldTemp = getTargetTemperature();
        setTargetTemperature(temp);
        // Здесь как-то должно быть реализовано ожидание, а в этот момент работает все остальное,
        // но я не знаю как в java сделать многопоточность.
        setTargetTemperature(oldTemp);
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
