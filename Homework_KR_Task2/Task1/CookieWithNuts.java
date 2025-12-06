package Homework_KR_Task2.Task1;

public class CookieWithNuts extends SweetCookie{
    public CookieWithNuts(int calories, int sweetLevel) {
        super(calories, sweetLevel);
    }

    public CookieWithNuts() {
        this(0, 0);
    }

    @Override
    public void bake() {
        super.bake();
        System.out.print("И потом еще орехи сверху насыпаются");
    }

    public String checkTypeOfNuts() {
        return "Грецкий орех";
    }
}
