package Homework_Podgotovka_CW_1.Task4;

import java.util.*;
import java.util.stream.Collectors;

public class MovieApp {
    public static void main(String[] args) {
        List<Director> directors = DataGenerator_Task4.generateDirectors();
        List<Movie> movies = DataGenerator_Task4.generateMovies();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int command = sc.nextInt();
            if (command == 0) break;

            switch (command) {
                case 1:
                    movies.stream()
                            .map(m -> {
                                String dirName = directors.stream()
                                        .filter(d -> d.getId() == m.getDirectorId())
                                        .findFirst().map(Director::getName).orElse("нет ниче");
                                return m.getTitle() + m.getYear()+ dirName+ m.getRating();
                            })
                            .forEach(System.out::println);
                    break;

                case 2:
                    Map<String, Double> ratingToDirector = movies.stream()
                            .collect(Collectors.groupingBy(
                                    m -> directors.stream()
                                            .filter(d -> d.getId() == m.getDirectorId())
                                            .findFirst().map(Director::getName).orElse("нет ниче"),
                                    Collectors.averagingDouble(Movie::getRating)
                            ));
                    ratingToDirector.forEach((dir, avg) ->
                            System.out.printf(dir + "->" + avg));
                    break;

                case 3:
                    movies.stream()
                            .filter(m -> m.getYear() > 2010)
                            .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                            .limit(3)
                            .forEach(m -> System.out.println(m.getTitle() + " — " + m.getRating()));
                    break;

                case 4:
                    movies.stream()
                            .min(Comparator.comparingDouble(Movie::getRating))
                            .ifPresent(m -> System.out.println(m.getTitle() + m.getRating()));
                    break;

                case 5:
                    Map<String, Double> titleToRating = movies.stream()
                            .collect(Collectors.toMap(Movie::getTitle, Movie::getRating));
                    titleToRating.forEach((title, rating) -> System.out.println(title + " -> " + rating));
                    break;

                case 6:
                    Map<Director, List<Movie>> DirectorToMovies = movies.stream()
                            .collect(Collectors.groupingBy(m ->
                                    directors.stream()
                                            .filter(d -> d.getId() == m.getDirectorId())
                                            .findFirst().orElse(null)
                            ));
                    List<String> allTitles = DirectorToMovies.values().stream()
                            .flatMap(List::stream)
                            .map(Movie::getTitle)
                            .collect(Collectors.toList());
                    System.out.println("Все названия: " + allTitles);
                    break;

            }
        }
    }
}