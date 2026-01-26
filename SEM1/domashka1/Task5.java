package SEM1.domashka1;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        float x = scanner.nextFloat();
        float y = scanner.nextFloat();
        int n = scanner.nextInt();
        System.out.println(x * x < (n * n) / 2 && y * y < (n * n) / 2);
        }
        }
