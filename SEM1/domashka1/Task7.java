package SEM1.domashka1;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        float x = scanner.nextFloat();
        float y = scanner.nextFloat();
        float pifagorVkvadrate = x * x + y * y;
        boolean flag = true;
        for (int n = 1; n <= 10; n++) {
            if (pifagorVkvadrate <= n * n) {System.out.println(n);
                flag = false;
                break;}}
            if (flag) {System.out.println("missed");}
        }
        }
