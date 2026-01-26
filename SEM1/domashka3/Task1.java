package SEM1.domashka3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n;
        boolean[] flags = new boolean[x]; // список для столбцов
        for (int i = 0; i < x; i++) {flags[i] = true;}
        for (int i = 0; i < y; i++) { // i строка и j столбец
            for (int j = 0; j < x; j++) {
                n = sc.nextInt();
                if (n % 3 != 0) {flags[j] = false;}
            }
        }
        boolean flag = false;
        for (int i = 0; i < x; i++) {
            if (flags[i]) {flag=true;break;}
        }
        System.out.println(flag);
    }
}
