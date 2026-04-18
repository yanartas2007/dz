package Homework_Podgotovka_CW_1.Task1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HotelApp {
    public static void main(String[] args) {
        List<Room> rooms = DataGenerator_Task1.generateRooms();
        List<Client> clients = DataGenerator_Task1.generateClients();
        List<Booking> bookings = DataGenerator_Task1.generateBookings(clients, rooms);
        Scanner sc = new Scanner(System.in);

        System.out.println("1 — Вывести всех клиентов и их бронирования\n" +
                "2 — Вывести суммарную выручку по каждому номеру\n" +
                "3 — Вывести топ-3 самых дорогих номера среди тех, что были забронированы хотя бы раз\n" +
                "4 — Найти клиента с наибольшей суммарной стоимостью всех бронирований\n" +
                "5 — Вывести Map<String, Double>: номер комнаты → цена за ночь\n" +
                "6 – Вывести список всех дат заезда (checkInDate) по всем клиентам\n" +
                "0 — Завершить программу\n");

        while (true) {
            int command = sc.nextInt();
            if (command == 0) break;

            switch (command) {
                case 1:
                    bookings.stream().forEach(n->System.out.println(n));
                    break;
                case 2:
                    Map<String, Double> RoomToSUm = bookings.stream()
                            .collect(Collectors.groupingBy(
                                    b -> b.room.roomNumber,
                                    Collectors.summingDouble(b -> b.room.pricePerNight *
                                            (b.checkOutDate.toEpochDay() - b.checkInDate.toEpochDay()))
                            ));
                    RoomToSUm.forEach((roomNum, summ) ->
                            System.out.println(roomNum + " → " + summ));
                    break;
                case 3:
                    bookings.stream()
                            .map(b -> b.room)
                            .distinct()
                            .sorted((r1, r2) -> Double.compare(r2.pricePerNight, r1.pricePerNight))
                            .limit(3)
                            .forEach(r -> System.out.println(r.roomNumber + " — " + r.pricePerNight));
                    break;

                case 4:
                    bookings.stream()
                            .collect(Collectors.groupingBy(
                                    b -> b.client,
                                    Collectors.summingDouble(b -> b.room.pricePerNight *
                                            (b.checkOutDate.toEpochDay() - b.checkInDate.toEpochDay())) // группирует и сразы выдает суммы
                            ))
                            .entrySet().stream() // переделываем в set
                            .max(Map.Entry.comparingByValue())
                            .ifPresent(entry -> System.out.println(entry.getKey().name +
                                    ": " + entry.getValue()));
                    break;

                case 5:
                    Map<String, Double> roomToPrice = rooms.stream()
                            .collect(Collectors.toMap(r -> r.roomNumber, r -> r.pricePerNight)); // toMap очень удобная штука. раньше циклом делал, а теперь прочитал что можно так
                    roomToPrice.forEach((num, price) -> System.out.println(num + " -> " + price));
                    break;

                case 6:
                    List<LocalDate> checkInDates = bookings.stream()
                            .map(b -> b.checkInDate)
                            .collect(Collectors.toList());
                    checkInDates.forEach(System.out::println);
                    break;
            }
        }
    }
}