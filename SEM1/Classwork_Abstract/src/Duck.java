package SEM1.Classwork_Abstract.src;

public class Duck extends Animal implements Runnable, Swimmable{
    public void makeSound() {
        System.out.println("Кря");
    }

    public Duck() {
        super();
    }

    public void run() {System.out.println("Уточка бежит");}

    public void swim() {System.out.println("Уточка плывет");}
}
