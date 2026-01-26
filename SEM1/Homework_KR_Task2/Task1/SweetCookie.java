package SEM1.Homework_KR_Task2.Task1;

public class SweetCookie extends Cookie{
    private int sweetLevel;

    public SweetCookie(int calories, int sweetLevel) {
        super(calories);
        setSweetlevel(sweetLevel);
    }

    public SweetCookie() {
        this(0, 1);
    }

    @Override
    public void bake() {
        System.out.print("печется 15 минут...");
        System.out.print("посыпается сахарной пудрой...");
    }

    public int getSweetlevel() {
        return sweetLevel;
    }

    public void setSweetlevel(int sweetlevel){
        this.sweetLevel = sweetlevel;
    }
}
