package _4_2_Classwork;

import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> treasures = new LinkedList<>();
        Thread t1 = new Thread(new TreasuresCreator(treasures));
        Thread t2 = new Thread(new TreasuresCreator(treasures));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(treasures.size());
    }
}
