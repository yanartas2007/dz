package SEM1.domashka3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n;
        int[] flags = new int[x];
        for (int i = 0; i < y; i++) {flags[i] = 0;}
        for (int i = 0; i < y; i++) { // i строка и j столбец
            for (int j = 0; j < x; j++) {
                n = sc.nextInt();
                if (suma_cifr_kratn_5(n)) {flags[i] += 1;}
            }
        }
        boolean flag = true;
        for (int i = 0; i < x; i++) {
            if (flags[i] < 2) {flag=false;break;}
        }
        System.out.println(flag);
    }
    public static boolean suma_cifr_kratn_5(int n) {
        int summa = 0;
        while (n > 9) {summa += n % 10; n/=10;}
        summa += n;
        return summa % 5 == 0;
    }
}
