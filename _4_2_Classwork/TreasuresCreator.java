package _4_2_Classwork;

import java.util.List;
import java.util.Random;

public class TreasuresCreator implements Runnable{
    private List<String> treasures;

    public TreasuresCreator(List<String> treasures) {
        this.treasures = treasures;
    }

    @Override
    public void run() {
        String[] items = new String[]{"Gold", "Silver", "Diamond"};
        Random r = new Random(42);
        for (int i = 0; i<1000;i++) {
            synchronized (treasures) {
                treasures.add(items[Math.abs(r.nextInt() % 3)]);
            }
        }
    }
}
