package domashka2;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rez = 0;
        int a;
        for (int i = 1; i <= n; i++) {
            a = 2;
            for (int j = 1; j < i; j++) {
                a *= 2;
            }
            rez += a;
        }
        System.out.println(rez);
        }
    }

