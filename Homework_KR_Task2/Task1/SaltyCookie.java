package Homework_KR_Task2.Task1;

public class SaltyCookie extends Cookie{
    private int saltLevel;

    public SaltyCookie(int calories, int saltLevel) {
        super(calories);
        setSaltLevel(saltLevel);
    }

    public SaltyCookie() {
        this(0, 1);
    }

    @Override
    public void bake() {
        System.out.print("жарится 30 минут...");
        System.out.print("посыпается солью...");
    }


    public int getSaltLevel() {
        return saltLevel;
    }

    public void setSaltLevel(int saltLevel) {
        this.saltLevel = saltLevel;
    }
}
