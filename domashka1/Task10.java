package domashka1;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int k = scanner.nextInt();
        int mnojitel = 1;
        while (k != 0) {System.out.print((k - k / 10 * 10) * mnojitel);
            boolean flag = k > 9;
        k /= 10;
        mnojitel *= 10;
        if (flag) {System.out.print(" + ");}}
        System.out.println();
        }
        }

