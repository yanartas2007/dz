package SEM1.Classwork_ООП_3.src;

public class Warrior extends GameCharacter{
    private double strength;
    private double armor;
    private String weaponType;

    public Warrior() {
        super();
        strength = 0;
        armor = 0;
        weaponType = "";
    }

    public String displayInfo() {
        return weaponType;
    }

    public void useSpecialAbility() {
        System.out.println("БЕРСЕРК");
    }

    public void attack() {System.out.println(getName() + " Атакует");}
    public void attack(String weapon) {System.out.println(getName() + " Атакует используя" + weapon);}
}
