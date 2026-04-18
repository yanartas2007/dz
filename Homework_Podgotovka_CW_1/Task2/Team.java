package Homework_Podgotovka_CW_1.Task2;

import java.util.Objects;

public class Team {
    private int id;
    private String name;
    private String country;
    private int ranking;

    public Team(int id, String name, String country, int ranking) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.ranking = ranking;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public int getRanking() { return ranking; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Team{id=" + id + ", name='" + name + "', country='" + country + "', ranking=" + ranking + "}";
    }
}