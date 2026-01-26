package SEM1.domashka2;
import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int rez = 0;
    for (int i = 1; i <= n; i++) {rez += factorial(i);}
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
