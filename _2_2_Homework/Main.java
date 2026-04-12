package _2_2_Homework;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Аслав");
        User user2 = new User(2, "Бслав");
        User user3 = new User(3, "Вслав");
        User user4 = new User(4, "Гслав");
        User user5 = new User(5, "Дслав");
        List<User> users = List.of(user1, user2, user3, user4, user5);

        Product nuggets = new Product(1, "Наггетс");
        Product bread = new Product(2, "Хлеб");
        Product shredingersCat = new Product(3, "Кот Шрёдингера");
        Product cheese = new Product(4, "Сыр");
        Product cake = new Product(5, "Кулич");
        List<Product> allProducts = List.of(nuggets, bread, shredingersCat, cheese, cake);

        Order order1 = new Order(101, user1, Arrays.asList(nuggets, bread, nuggets));
        Order order2 = new Order(102, user2, Arrays.asList(shredingersCat, cheese));
        Order order3 = new Order(103, user3, Arrays.asList(nuggets, bread, shredingersCat, nuggets));
        Order order4 = new Order(104, user1, Arrays.asList(cheese, cake));
        Order order5 = new Order(105, user2, Arrays.asList(nuggets, nuggets, nuggets));
        Order order6 = new Order(106, user4, Arrays.asList(bread, shredingersCat));
        Order order7 = new Order(107, user5, Arrays.asList(nuggets, bread, cheese, cake));
        List<Order> orders = List.of(order1, order2, order3, order4, order5, order6, order7);

        //1
        Map<User, Integer> uniqueProductsCount = orders.stream()
                .collect(Collectors.groupingBy(
                        n -> n.user,
                        Collectors.flatMapping(order -> order.products.stream().map(Product::getId),
                                Collectors.collectingAndThen(Collectors.toSet(), Set::size) // collectingAndThen заменяет результат на Set::size
                        )
                ));

        System.out.println("Наибольшее уникальных количество товаров" + uniqueProductsCount.values().stream().max(Integer::compare).get());
        System.out.println(uniqueProductsCount);


        //2
        List<Product> commonProducts = allProducts.stream()
                .filter(product -> users.stream().allMatch(user ->
                        orders.stream().anyMatch(order -> order.user.equals(user) &&
                                order.products.contains(product))
                ))
                .toList();

        System.out.println(commonProducts);

        //3
        double srednee = orders.stream()
                .mapToInt(order -> order.products.size()) // нашел в интеренете несколько интересных методов над стримами и теперь пытаюсь впихнуть их везде
                .average()
                .orElse(0.0);

        Map<User, Double> userAverage = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.user,
                        Collectors.averagingInt(order -> order.products.size()) // так засетно проще, чем сохранять и потом искать размер, делить...
                ));

        for (User user : users) {
            System.out.println(user.name + " " + userAverage.getOrDefault(user, 0.0));
        }
        System.out.println();

        //4
        int minSize = orders.stream()
                .mapToInt(order -> order.products.size())
                .min().getAsInt();

        List<Order> minOrders = orders.stream()
                .filter(order -> order.products.size() == minSize)
                .toList();

        System.out.println(minOrders);

        //5
        for (User user : users) {
            List<Order> userOrders = orders.stream()
                    .filter(order -> order.user.equals(user))
                    .toList();

            if (userOrders.isEmpty()) {
                System.out.println(user.name + " еще ничего не заказал");
                continue;
            }

            Map<Integer, Long> productFrequency = userOrders.stream()
                    .flatMap(order -> order.products.stream())
                    .collect(Collectors.groupingBy(Product::getId, Collectors.counting()));

            Optional<Map.Entry<Integer, Long>> maxEntry = productFrequency.entrySet().stream()
                    .max(Map.Entry.comparingByValue()); // entry разбивает map на пары ключ-значение, чтобы было удоюно по ним пройтись. не знаю что бы я делал без подсказок ide, а то тут не всегда очевидно, что к чему нужно преобразовать

            if (maxEntry.isPresent()) {
                int favProductId = maxEntry.get().getKey();
                long count = maxEntry.get().getValue();
                Product favProduct = allProducts.stream()
                        .filter(p -> p.id == favProductId)
                        .findFirst()
                        .orElse(null);
                assert favProduct != null;
                System.out.println(user.name + " чаще всего заказывает " +favProduct.name);
            }
        }
        System.out.println();

        //6
        List<Product> targetProducts = List.of(nuggets, bread);
        Set<Integer> targetIds = targetProducts.stream().map(p -> p.id).collect(Collectors.toSet());

        List<User> usersWhoOrderedAllFromTargetProducts = users.stream()
                .filter(user -> {
                    Set<Integer> userProductIds = orders.stream()
                            .filter(order -> order.user.equals(user))
                            .flatMap(order -> order.products.stream())
                            .map(Product::getId)
                            .collect(Collectors.toSet());
                    return userProductIds.containsAll(targetIds);
                })
                .toList();


        if (usersWhoOrderedAllFromTargetProducts.isEmpty()) {
            System.out.println("Нет пользователей, которые заказывали все эти товары.");
        } else {
            usersWhoOrderedAllFromTargetProducts.forEach(u -> System.out.println(u.name));
        }
    }
}