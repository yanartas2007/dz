package Homework_Podgotovka_CW_1.Task4;

import java.util.Objects;

public class Director {
    private int id;
    private String name;
    private int birthYear;

    public Director(int id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getBirthYear() { return birthYear; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Director{id=" + id + ", name='" + name + "', birthYear=" + birthYear + "}";
    }
}