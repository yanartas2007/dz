package domashka4;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        boolean[][] matrix = readboolmatrix();
        boolean flag = true;
        for (boolean[] i: matrix) {
            int flag2 = 0;
            for (boolean j: i) {
                if (j) {flag2 += 1; if (flag2 > 2) {break;};}
            }
            if (flag2 != 2) {
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
                matrix[y][x] = (isvozrast(n));
            }
        }
        return matrix;
    }
    public static boolean isvozrast(int n) {
        boolean flag = true;
        int n1 = n % 10;
        int n2;
        n /= 10;
        while (n > 0) {
            n2 = n % 10;
            n /= 10;
            if (n2 > n1) {flag=false;break;}
            n1 =  n2;
        }
        return flag;
    }
}
