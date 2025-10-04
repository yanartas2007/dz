package domashka4;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int[][] matrix = readsummatrix(height, width, sc);
        boolean flag = false;
        for (int x = 0; x < width; x++) {
            boolean flag2 = true;
            for (int y =0; y < height; y++) {
                if (matrix[y][x] != matrix[1][x]) {flag2 = false;break;}
            }
            if (flag2) {flag = true;break;}
        }
        System.out.println(flag);

    }

    public static int[][] readsummatrix(int height, int width, Scanner sc) {
        int[][] matrix = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println("Введите число по координатам " + y + " " + x);
                matrix[y][x] = summacifr(sc.nextInt());
            }
        }
        return matrix;
    }
    public static int summacifr(int n) {
        int n2 = 0;
        while (n > 0) {
            n2 += (n % 10);
            n /= 10;;
        }
        return n2;
    }
}
