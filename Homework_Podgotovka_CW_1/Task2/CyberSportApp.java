package Homework_Podgotovka_CW_1.Task2;

import java.util.*;
import java.util.stream.Collectors;

public class CyberSportApp {
    public static void main(String[] args) {
        List<Team> teams = DataGenerator_Task2.generateTeams();
        List<Player> players = DataGenerator_Task2.generatePlayers();
        Scanner sc = new Scanner(System.in);

        System.out.println("1 — Вывести список: ник, возраст, команда\n" +
                "2 — Средний рейтинг игроков по командам\n" +
                "3 — Топ-3 игрока с рейтингом (возраст ≥ 21)\n" +
                "4 — Самый молодой игрок\n" +
                "5 — Map<id игрока, никнейм>\n" +
                "6 — Группировка по командам + список всех никнеймов\n" +
                "0 — Выход");

        while (true) {
            int command = sc.nextInt();
            if (command == 0) break;

            switch (command) {
                case 1:
                    players.stream()
                            .map(p -> {
                                String teamName = teams.stream()
                                        .filter(t -> t.getId() == p.getTeamId())
                                        .findFirst()
                                        .map(Team::getName)
                                        .orElse("Unknown");
                                return p.getNickname() +" "+ p.getAge() +" "+ teamName;
                            })
                            .forEach(System.out::println);
                    break;

                case 2:
                    Map<String, Double> CommandToAverageRating = players.stream()
                            .collect(Collectors.groupingBy(
                                    p -> teams.stream()
                                            .filter(t -> t.getId() == p.getTeamId())
                                            .findFirst().map(Team::getName).orElse("нет ниче"),
                                    Collectors.averagingDouble(Player::getRating)
                            ));
                    CommandToAverageRating.forEach((team, avg) ->
                            System.out.println(team + "->" + avg));
                    break;

                case 3:
                    players.stream()
                            .filter(p -> p.getAge() >= 21)
                            .sorted((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()))
                            .limit(3)
                            .forEach(p -> System.out.println(p.getNickname() + "рейтинг: " + p.getRating()));
                    break;

                case 4:
                    players.stream()
                            .min(Comparator.comparingInt(Player::getAge))
                            .ifPresent(p -> System.out.println(p.getNickname() + p.getAge()));
                    break;

                case 5:
                    Map<Integer, String> idToNickname = players.stream()
                            .collect(Collectors.toMap(Player::getId, Player::getNickname));
                    idToNickname.forEach((id, nick) -> System.out.println(id + " -> " + nick));
                    break;

                case 6:
                    Map<Team, List<Player>> playersByTeam = players.stream()
                            .collect(Collectors.groupingBy(p ->
                                    teams.stream()
                                            .filter(t -> t.getId() == p.getTeamId())
                                            .findFirst()
                                            .orElse(null)
                            ));
                    List<String> allNicknames = playersByTeam.values().stream()
                            .flatMap(List::stream)
                            .map(Player::getNickname)
                            .collect(Collectors.toList());
                    System.out.println(allNicknames);
                    break;
            }
        }
    }
}