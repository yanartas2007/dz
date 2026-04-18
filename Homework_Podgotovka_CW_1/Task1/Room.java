package Homework_Podgotovka_CW_1.Task1;

import java.util.Objects;

public class Room extends Entity<Integer> {
    public String roomNumber;
    public double pricePerNight;
    public int capacity;

    public Room(Integer id, String roomNumber, double pricePerNight, int capacity) {
        super(id);
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", pricePerNight=" + pricePerNight +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(pricePerNight, room.pricePerNight) == 0 && capacity == room.capacity && Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, pricePerNight, capacity);
    }
}
