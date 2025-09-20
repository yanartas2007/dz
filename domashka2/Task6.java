package domashka2;
import java.util.Scanner;
public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        float x = scanner.nextFloat();
        float rez = 0;
        for (int k = 1; k <= n; k++) {
            float x_v_stepeni_k = x;
            for (int m = 0; m < k; m++) {
                x_v_stepeni_k *= x;
            }
            rez += (factorial(k) * x_v_stepeni_k);
        }
        System.out.println(rez);
    }
    public static int factorial(int chislo) {
        int rez = 1;
        for (int i = 1; i <= chislo; i ++) {
            rez *= i;
        }
        return rez;
    }
}
