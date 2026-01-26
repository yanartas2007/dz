package SEM1.domashka1;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int k = scanner.nextInt();
        int summ = 0;
        int mnojitel = 1;
        while (k > 0) {summ += (k - k / 2 * 2) * mnojitel;
        k /= 2;
        mnojitel *= 10;}
        System.out.println(summ);
        }
        }

