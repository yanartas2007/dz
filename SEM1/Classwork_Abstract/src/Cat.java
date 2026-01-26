package SEM1.Classwork_Abstract.src;

public class Cat extends Animal{
    public int lives;

    public Cat(String name, int age, int lives) {
        super(name, age);
        this.lives = lives;
    }

    @Override
    public void makeSound() {
        System.out.println("МРМР");
    }

    public void climbATree() {
        System.out.println("Лезет на дерево");
    }
}
