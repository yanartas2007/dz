package SEM1.domashka3;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                System.out.print(i == j ? 1 : 0);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
