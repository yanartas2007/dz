package SEM1.Classwork_ООП_3.src;

public abstract class GameCharacter {
    private String name;
    private int level;
    private double mana;
    private boolean isAlive;
    private static int totalCharacters = 0;
    private final int MAX_LEVEL = 100;

    public static int getTotalCharacters() {
        return totalCharacters;
    }

    public GameCharacter(String name, int level, double mana, boolean isAlive) {
        this.name = name;
        this.level = level;
        this.mana = mana;
        this.isAlive = isAlive;
    }

    public GameCharacter() {
        this("NO_NAME", 0, 0, true);
    }

    public abstract String displayInfo();
    public abstract void useSpecialAbility();

    public void attack () {System.out.println(name + " Атакует");}
    public void takeDamage(double damage) {System.out.println(name + " ударяется");}
    public void heal(double amount) {System.out.println(name + " лечится");}

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }


}
