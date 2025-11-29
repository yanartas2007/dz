public class Bird extends Animal{
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("чик-чирик");
    }

    public void fly() {
        assert canFly;
        System.out.println("летает");
    }
}
