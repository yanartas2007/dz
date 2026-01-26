package SEM1.domashka4;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n / 2 || j == n /2) {System.out.print("1 ");}
                else {System.out.print("0 ");}
            }
            System.out.println();
        }
    }
}
