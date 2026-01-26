package SEM1.Homework_ООП_3.Task2;

public class MainCourse extends MenuItem{
    private String mainIngredient;
    private String sideDish;
    private int calories;

    public MainCourse(String itemId, String name, double price, int cookingTime, boolean isAvailable, String mainIngredient, String sideDish, int calories) {
        super(itemId, name, price, cookingTime, isAvailable);
        setMainIngredient(mainIngredient);
        setSideDish(sideDish);
        setCalories(calories);
    }


    public String getItemType() {
        return "Основное блюдо";
    }

    public void prepare() {
        setIsAvailable(true);
    }

    public void updatePrice(double newPrice, String reason) {
        System.out.println(reason);
        updatePrice(newPrice);
    }

    public void changeSideDish(String newSideDish) {
        setSideDish(newSideDish);
    }

    public String getCookingInstructions() {
        return "Ну, не знаю. Попробуйте посмотреть в интернете.";
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public String getSideDish() {
        return sideDish;
    }

    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
