package SEM1.Classwork_ООП_3.src;

public class Mage extends GameCharacter{
    private double intelligence;
    private double spellPower;
    private String element;

    public Mage() {
        super();
        this.intelligence = 0;
        this.spellPower = 0;
        this.element = "";
    }

    public String displayInfo() {
        return "колдун";
    }

    public void useSpecialAbility() {
        System.out.println("щит");
    }

    public void castSpell(String spellName) {
        System.out.println(spellName);
    }

    public void meditate() {
        setMana(getMana() + 15);
    }
}
