package SEM1.Classwork_Abstract.src;

public class Dog extends Animal implements Runnable{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("гав");
    }

    public void run() {System.out.println("собачка бежит");}
}
