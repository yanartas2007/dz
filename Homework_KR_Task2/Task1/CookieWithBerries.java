package Homework_KR_Task2.Task1;

public class CookieWithBerries extends SweetCookie{
    public CookieWithBerries(int calories, int sweetLevel) {
        super(calories, sweetLevel);
    }

    public CookieWithBerries() {
        this(0, 0);
    }

    @Override
    public void bake() {
        super.bake();
        System.out.print("И потом еще ягоды сверху насыпаются");
    }

    public String checkTypeOfBerries() {
        return "Черника";
    }
}
