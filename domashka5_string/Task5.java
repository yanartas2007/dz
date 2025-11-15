package domashka5_string;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dlina = sc.nextInt();
        int v = sc.nextInt();
        sc.nextLine();

        String[][] massive = new String[v][dlina];
        for (int y = 0; y < v; y++) {
            for (int x = 0; x < dlina; x ++) {
                massive[y][x] = sc.nextLine();
            }
        }

        String[][] transponirovanniy_massive = new String[dlina][v];
        for (int y = 0; y < v; y++) {
            for (int x = 0; x < dlina; x ++) {
                transponirovanniy_massive[x][y] = massive[y][x];
            }
        }

        for (String[] s1: transponirovanniy_massive) {
            for (String s2: s1) {
                System.out.print(s2);
            }
            System.out.println();
        }

    }
}
