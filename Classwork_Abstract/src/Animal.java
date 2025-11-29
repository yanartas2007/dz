public abstract class Animal {
    private String name;
    private int age;


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
        this("🦠", 100);
    }

    public void eat() {
        System.out.println(name + " Жрет");
    }

    public void sleep() {
        System.out.println(name + " Спит");
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

}
