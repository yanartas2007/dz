package SEM1.domashka2;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rez = 0;
        int a;
        for (int i = 1; i <= n; i++) {
            a = n;
            for (int j = 1; j < i; j++) {
                a *= n;
            }
            rez += a;
//            System.out.println(a);
        }
        System.out.println(rez);
    }
}
