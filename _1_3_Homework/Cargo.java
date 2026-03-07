package _1_3_Homework;

public abstract class Cargo {
    private String name;

    public Cargo(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
