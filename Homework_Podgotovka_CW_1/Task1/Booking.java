package Homework_Podgotovka_CW_1.Task1;

import java.time.LocalDate;
import java.util.Objects;

public class Booking extends Entity<Integer>{
    public Client client;
    public Room room;
    public LocalDate checkInDate;
    public LocalDate checkOutDate;

    public Booking(Integer id, Client client, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        super(id);
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Бронирование" +
                "клиент:" + client +
                ", номер:" + room +
                ", заезд:" + checkInDate +
                ", выезд:" + checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(client, booking.client) && Objects.equals(room, booking.room) && Objects.equals(checkInDate, booking.checkInDate) && Objects.equals(checkOutDate, booking.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, room, checkInDate, checkOutDate);
    }
}
