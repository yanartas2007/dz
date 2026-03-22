package _1_5_Homework.Task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitorTests {
    @Test
    public void Test1() {
        MyHashSet<Visitor> hsv = new MyHashSet<>();
        Visitor vasya = new Visitor("Василий", "123");
        hsv.add(vasya);
        Assertions.assertTrue(hsv.contains(vasya));
        vasya.setPassId("999");
        Assertions.assertFalse(hsv.contains(vasya)); // считается, что его тут нет, так как хеш изменился и мы не можем его найти
    }
}
