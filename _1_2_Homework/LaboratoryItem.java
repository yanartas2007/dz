package _1_2_Homework;

public class LaboratoryItem{
    private String serialNumber;
    private int biohazardLevel;
    private Integer sessionId;

    public LaboratoryItem(String serialNumber, int biohazardLevel, Integer sessionId) {
        setBiohazardLevel(biohazardLevel);
        setSerialNumber(serialNumber);
        setSessionId(sessionId);
    }

    public void setSerialNumber(String n){this.serialNumber=n;}
    public String getSerialNumber(){
        return this.serialNumber;}

    public void setBiohazardLevel(int n){this.biohazardLevel=n;}
    public int getBiohazardLevel(){
        return this.biohazardLevel;}

    public void setSessionId(Integer n){this.sessionId=n;}
    public Integer getSessionId(){
        return this.sessionId;}
}