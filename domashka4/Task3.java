package domashka4;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        boolean[][] matrix = readboolmatrix();
        boolean flag = true;
        for (boolean[] i: matrix) {
            boolean flag2 = false;
            for (boolean j: i) {
                if (j) {flag2 = true; break;}
            }
            if (!flag2) {
                flag = false; break;
            }
        }
        System.out.println(flag);

    }

    public static boolean[][] readboolmatrix() {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        boolean[][] matrix = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println("Введите число по координатам " + y + " " + x);
                int n = sc.nextInt();
                matrix[y][x] = (isprostoe(n) && isprostoe(summacifr(n)));
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
    public static boolean isprostoe(int n) {
        boolean flag = true;
        for (int i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0) {flag = false;break;}
        }
        return flag;
    }
}
