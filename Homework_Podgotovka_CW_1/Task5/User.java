package Homework_Podgotovka_CW_1.Task5;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int age;
    private int subscriptionId;
    private int watchHoursPerMonth;
    private List<String> genres;

    public User(int id, String name, int age, int subscriptionId, int watchHoursPerMonth, List<String> genres) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subscriptionId = subscriptionId;
        this.watchHoursPerMonth = watchHoursPerMonth;
        this.genres = genres;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getSubscriptionId() { return subscriptionId; }
    public int getWatchHoursPerMonth() { return watchHoursPerMonth; }
    public List<String> getGenres() { return genres; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', age=" + age +
                ", subscriptionId=" + subscriptionId + ", watchHours=" + watchHoursPerMonth + "}";
    }
}