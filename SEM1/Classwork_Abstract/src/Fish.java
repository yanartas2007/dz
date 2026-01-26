package SEM1.Classwork_Abstract.src;

public class Fish extends Animal implements Swimmable{
    public void makeSound() {
        System.out.println("...");
    }

    public Fish() {
        super();
    }

    public void swim() {
        System.out.println("Рыбка плывет");
    }
}
