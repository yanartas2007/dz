package domashka1;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        float x = scanner.nextFloat();
        float y = scanner.nextFloat();
        int n = scanner.nextInt();
        float pifagorVkvadrate = x * x + y * y;
        System.out.println(pifagorVkvadrate < n * n);
        }
        }
