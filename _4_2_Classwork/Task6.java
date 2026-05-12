package _4_2_Classwork;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Task6 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\dz\\_4_2_Classwork\\words.txt"));
            LinkedList<String>[] parts = new LinkedList[4];
            for (int j = 0; j<4;j++) {
                parts[j] = new LinkedList<>();
            }

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                parts[i % 4].add(line);
            }

            final long[] totalCount = {0};
            Thread[] t = new Thread[4];
            for (int j = 0; j<4;j++) {
                int finalJ = j; // еще какие то махинации от ide. но кажется я уловил суть: нельзя использовать примитив в лямбде
                t[j] = new Thread(() -> {for (String s: parts[finalJ]) {
                    synchronized (totalCount) {
                        totalCount[0] += Arrays.stream(s.split(" ")).filter(n -> n.length() > 3).toList().size();
                    }
                }});
                t[j].start();
            }
            for (int j = 0; j<4;j++) {
                t[j].join();
            }
            System.out.println(totalCount[0]);
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }
}
