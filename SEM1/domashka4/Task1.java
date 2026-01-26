package SEM1.domashka4;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int[][] matrix = readmatrix();
        boolean flag = true;
        for (int[] i: matrix) {
            int flag2 = 0;
            for (int j: i) {
                if (ispolindrome(j)) {
                    flag2 += 1;
                    if (flag2 == 2) {break;}
                }
            }
            if (flag2 != 1) {flag = false; break;}
        }
        System.out.println(flag);
    }

    public static boolean ispolindrome(int n) {
        int n1 = n;
        int n2 = 0;
        int n_copy = n;
        int mnojitel = 1;
        while (n_copy > 0) {
            n_copy /= 10;
            mnojitel *= 10;}
        mnojitel /= 10;
        while (n > 0) {
            n2 += (n % 10) * mnojitel;
            n /= 10;
            mnojitel /= 10;
        }
        return n1 == n2;
    }

    public static int[][] readmatrix() {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int[][] matrix = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println("Введите число по координатам " + y + " " + x);
                matrix[y][x] = sc.nextInt();
            }
        }
        return matrix;
    }
}
