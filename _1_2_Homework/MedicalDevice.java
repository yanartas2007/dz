package _1_2_Homework;

public class MedicalDevice extends LaboratoryItem{
    private String deviceName;
    private double precision;

    public MedicalDevice(String serialNumber, int biohazardLevel, Integer sessionId, String n1, double n2) {
        super(serialNumber, biohazardLevel, sessionId);
        setDeviceName(n1);
        setPrecision(n2);
    }
    public void setDeviceName(String n){this.deviceName=n;}
    public String getDeviseName(){
        return this.deviceName;}

    public void setPrecision(double n){this.precision=n;}
    public double getPrecision(){
        return this.precision;}
}