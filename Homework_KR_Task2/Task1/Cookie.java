package Homework_KR_Task2.Task1;

public abstract class Cookie { // пирог
    private int calories;

    public Cookie(int calories) {
        setCalories(calories);
    }

    public Cookie() {
        this(0);
    }

    public abstract void bake();

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
