package SEM1.Homework_ООП_3.Task1;

public class SmartHome {
    private String homeName;
    private SmartDevice[] devices;

    public void addDevice(SmartDevice device) {
        SmartDevice[] devices1 = new SmartDevice[devices.length + 1];
        for (int i = 0; i < devices.length; i++) {
            devices1[i] = devices[i];
        }
        devices1[devices.length + 1] = device;
        devices = devices1;
    }

    public void removeDevice(String deviceId) {
        SmartDevice[] devices1 = new SmartDevice[devices.length - 1];
        boolean flag = false;
        for (int i = 0; i < devices.length; i++) {
            if (devices1[i].getDeviceId().equals(deviceId)) {flag = true;}
            else {devices1[flag ? i - 1: i] = devices[i];}
        }
        assert flag;
        devices = devices1;
    }

    public void turnOnAllDevices() {
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOn();
        }
    }

    public void turnOffAllDevices() {
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOff();
        }
    }

    public SmartDevice[] getDevicesByType(String type) {
        int d = 0;
        for (SmartDevice i: devices) {
            if (i.getDeviceType().equals(type)) {d++;}
        }
        SmartDevice[] ret = new SmartDevice[d];
        int n = 0;
        for (SmartDevice i: devices) {
            if (i.getDeviceType().equals(type)) {ret[n]=i; n++;}
        }
        return ret;
    }

    public double calculateTotalPowerConsumption() {
        double ret = 0;
        for (int i = 0; i < devices.length; i++) {
            ret += devices[i].getPowerConsumption();
        }
        return ret;
    }

    public String getDeviceStatus(String deviceId) {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getDeviceId().equals(deviceId)) {return devices[i].getStatus();}
        }
        return "DEVICE_NOT_FOUND";
    }
}
