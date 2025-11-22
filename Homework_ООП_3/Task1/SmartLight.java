package Homework_ООП_3.Task1;

public class SmartLight extends SmartDevice{
    private int brightness;
    private String color;
    private boolean isColorChanging;

    public SmartLight(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption, int brightness, String color, boolean isColorChanging) {
        super(deviceId, deviceName, location, isPoweredOn, powerConsumption);
        setBrightness(brightness);
        setColor(color);
        setIsColorChanging(isColorChanging);
    }

    @Override
    public String getDeviceType() {
        return "Умная лампа";
    }

    @Override
    public void performAction() {
        if (getBrightness() == 0) {setBrightness(100);}
        else {setBrightness(0);}
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int level) {
        assert brightness >= 0 && brightness <= 100;
        this.brightness = level;
    }

    public void setBrightness(int level, String color) {
        setBrightness(level);
        setColor(color);
    }

    public void changeColor(String newColor) {
        setColor(newColor);
    }

    public void dimLights() {
        if (getBrightness() > 10) {setBrightness(getBrightness() - 10);}
        else {setBrightness(1);}
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        assert getIsColorChanging();
        this.color = color;
    }

    public boolean getIsColorChanging() {
        return isColorChanging;
    }

    public void setIsColorChanging(boolean colorChanging) {
        isColorChanging = colorChanging;
    }
}
