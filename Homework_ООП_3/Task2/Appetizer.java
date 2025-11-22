package Homework_ООП_3.Task2;

public class Appetizer extends MenuItem{
    private String servingTemperature;
    private boolean isVegetarian;
    private int spiceLevel;

    public Appetizer(String itemId, String name, double price, int cookingTime, boolean isAvailable, String servingTemperature, boolean isVegetarian, int spiceLevel) {
        super(itemId, name, price, cookingTime, isAvailable);
        setServingTemperature(servingTemperature);
        setIsVegetarian(isVegetarian);
        setSpiceLevel(spiceLevel);
    }


    public String getItemType() {
        return "Закуска";
    }

    public void prepare() {
        setIsAvailable(true);
    }

    public String displayInfo(boolean showDetails) {
        return super.displayInfo() + (!showDetails ?"": servingTemperature);
    }

    public void changeSpiceLevel(int spiceLevel) {
        setSpiceLevel(spiceLevel);
    }

    public int getNutritionInfo() {
        return isVegetarian ? 1000: 0;
    }

    public String getServingTemperature() {
        return servingTemperature;
    }

    public void setServingTemperature(String servingTemperature) {
        this.servingTemperature = servingTemperature;
    }

    public boolean GetIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public int getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(int spiceLevel) {
        assert spiceLevel > 0 && spiceLevel < 6;
        this.spiceLevel = spiceLevel;
    }
}
