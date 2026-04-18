package Homework_Podgotovka_CW_1.Task4;

import java.util.Objects;

public class Movie {
    private int id;
    private String title;
    private int year;
    private double rating;
    private int directorId;

    public Movie(int id, String title, int year, double rating, int directorId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.directorId = directorId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public double getRating() { return rating; }
    public int getDirectorId() { return directorId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Movie{id=" + id + ", title='" + title + "', year=" + year +
                ", rating=" + rating + ", directorId=" + directorId + "}";
    }
}