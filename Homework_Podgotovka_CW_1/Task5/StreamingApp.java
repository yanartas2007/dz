package Homework_Podgotovka_CW_1.Task5;

import java.util.*;
import java.util.stream.Collectors;

public class StreamingApp {
    public static void main(String[] args) {
        List<Subscription> subscriptions = DataGenerator_Task5.generateSubscriptions();
        List<User> users = DataGenerator_Task5.generateUsers();
        Scanner sc = new Scanner(System.in);


        while (true) {
            int command = sc.nextInt();
            if (command == 0) break;

            switch (command) {
                case 1:
                    users.stream()
                            .map(u -> {
                                Subscription sub = subscriptions.stream()
                                        .filter(s -> s.getId() == u.getSubscriptionId())
                                        .findFirst().orElse(null);
                                String premium = (sub != null && sub.isPremium()) ? "да" : "нет";
                                String service = (sub != null) ? sub.getServiceName() : "Unknown";
                                return u.getName()+ u.getAge()+ service+ premium+ u.getWatchHoursPerMonth();
                            })
                            .forEach(System.out::println);
                    break;

                case 2:
                    Map<String, Integer> ServiseToHours = users.stream()
                            .collect(Collectors.groupingBy(
                                    u -> subscriptions.stream()
                                            .filter(s -> s.getId() == u.getSubscriptionId())
                                            .findFirst().map(Subscription::getServiceName).orElse("Unknown"),
                                    Collectors.summingInt(User::getWatchHoursPerMonth)
                            ));
                    ServiseToHours.forEach((service, hours) -> System.out.println(service + " → " + hours));
                    break;

                case 3:
                    users.stream()
                            .filter(u -> u.getAge() < 30)
                            .sorted((u1, u2) -> Integer.compare(u2.getWatchHoursPerMonth(), u1.getWatchHoursPerMonth()))
                            .limit(3)
                            .forEach(u -> System.out.println(u.getName() + " - " + u.getWatchHoursPerMonth()));
                    break;

                case 4:
                    users.stream()
                            .min(Comparator.comparingInt(User::getWatchHoursPerMonth))
                            .ifPresent(u -> System.out.println(u.getName() + u.getWatchHoursPerMonth()));
                    break;

                case 5:
                    Map<String, Boolean> premiumMap = users.stream()
                            .collect(Collectors.toMap(
                                    User::getName,
                                    u -> subscriptions.stream()
                                            .filter(s -> s.getId() == u.getSubscriptionId())
                                            .findFirst().map(Subscription::isPremium).orElse(false)
                            ));
                    premiumMap.forEach((name, premium) -> System.out.println(name + " -> " + (premium ? "да" : "нет")));
                    break;

                case 6:
                    List<String> allGenres = users.stream()
                            .flatMap(u -> u.getGenres().stream())
                            .collect(Collectors.toList());
                    System.out.println("Все жанры: " + allGenres);
                    break;

            }
        }
    }
}