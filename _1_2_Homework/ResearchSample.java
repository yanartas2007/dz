package _1_2_Homework;

public class ResearchSample<T extends Number> extends LaboratoryItem{
    private String materialName;
    private T purity;

    public ResearchSample(String serialNumber, int biohazardLevel, Integer sessionId, String materialName, T purity) {
        super(serialNumber, biohazardLevel, sessionId);
        setPurity(purity);
        setMaterialName(materialName);
    }

    public void setMaterialName(String n){this.materialName=n;}
    public String getMaterialName(){
        return this.materialName;}

    public void setPurity(T n){this.purity=n;}
    public T getPurity(){
        return this.purity;}

    public void setPurity(double v) {
        setPurity((T) (Number) v);
    }
}