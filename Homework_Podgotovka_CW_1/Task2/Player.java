package Homework_Podgotovka_CW_1.Task2;

import java.util.Objects;

public class Player {
    private int id;
    private String nickname;
    private int age;
    private int teamId;
    private double rating;

    public Player(int id, String nickname, int age, int teamId, double rating) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.teamId = teamId;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getNickname() { return nickname; }
    public int getAge() { return age; }
    public int getTeamId() { return teamId; }
    public double getRating() { return rating; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Player{id=" + id + ", nickname='" + nickname + "', age=" + age +
                ", teamId=" + teamId + ", rating=" + rating + "}";
    }
}