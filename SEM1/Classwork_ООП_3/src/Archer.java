package SEM1.Classwork_ООП_3.src;

public class Archer extends GameCharacter{
    private double agility;
    private double accuracy;
    private String arrowType;

    public Archer() {
        super();
        this.agility = 0;
        this.accuracy = 0;
        this.arrowType = "";
    }

    public String displayInfo() {
        return arrowType;
    }

    public void useSpecialAbility() {
        System.out.println("Прицелился");
    }

    public void attack() {
        System.out.println("Выстрелил в воздух");
    };
    public void attack(String target, double distanse) {
        System.out.println("Попал");
    }
}
