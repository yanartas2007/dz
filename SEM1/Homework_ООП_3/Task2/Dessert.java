package SEM1.Homework_ООП_3.Task2;

public class Dessert extends MenuItem{
    private int sweetnessLevel;
    private boolean containsNuts;
    private boolean isGlutenFree;

    public Dessert(String itemId, String name, double price, int cookingTime, boolean isAvailable, int sweetnessLevel, boolean containsNuts, boolean isGlutenFree) {
        super(itemId, name, price, cookingTime, isAvailable);
        setSweetnessLevel(sweetnessLevel);
        setContainsNuts(containsNuts);
        setIsGlutenFree(isGlutenFree);
    }


    public String getItemType() {
        return "Десерт";
    }

    public void prepare() {
        setIsAvailable(true);
    }

    public void prepare(boolean withExtraDecoration) {
        prepare();
        System.out.println(withExtraDecoration);
    }

    public void addTopping(String topping) {
        setName(getName() + " with " + topping);
    }

    public boolean checkAllergies() {
        return containsNuts || !isGlutenFree;
    }


    public int getSweetnessLevel() {
        return sweetnessLevel;
    }

    public void setSweetnessLevel(int sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }

    public boolean isContainsNuts() {
        return containsNuts;
    }

    public void setContainsNuts(boolean containsNuts) {
        this.containsNuts = containsNuts;
    }

    public boolean GetIsGlutenFree() {
        return isGlutenFree;
    }

    public void setIsGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }
}
