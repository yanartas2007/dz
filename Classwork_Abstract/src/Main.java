public class Main {
    public static void main(String[] args) {
        Dog d = new Dog("собак", 10, "узбецкая сине-зеленая");
        Fish f = new Fish();
        Duck u = new Duck();

        Animal[] a = {d, f, u};

        for (Animal i: a) {
            i.makeSound();
            i.sleep();
            if (i instanceof Swimmable) {
                ((Swimmable) i).swim();
            }
            if (i instanceof Runnable) {
                ((Runnable) i).run();
                ((Runnable) i).getMaxSpeed();
            }
        }

    }
}
