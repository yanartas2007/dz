package SEM1.domashka4;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edinichki = 1;
        int nuli = (n - 1) / 2;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < nuli; k++) {System.out.print("0 ");}
            for (int k = 0; k < edinichki; k++) {System.out.print("1 ");}
            for (int k = 0; k < nuli; k++) {System.out.print("0 ");}
            System.out.println();
            if (i < n / 2) {
                edinichki += 2;
                nuli -= 1;
            } else {
                edinichki -= 2;
                nuli += 1;
            }
        }
    }
}
