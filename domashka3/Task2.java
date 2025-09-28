package domashka3;

import java.util.Scanner;

public class Task2 {
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
                if (vse_cifru_chetnye(n)) {flags[i] += 1;}
            }
        }
        boolean flag = false;
        for (int i = 0; i < x; i++) {
            if (flags[i] == 1) {flag=true;break;}
        }
        System.out.println(flag);
    }
    public static boolean vse_cifru_chetnye(int n) {
        boolean flag = true;
        int l;
        while (n > 0) {l = n % 10; n /= 10; if (l % 2 == 1) {flag = false;break;}}
        return flag;
    }
}
