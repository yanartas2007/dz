package SEM1.domashka1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();
        if (c >= b && c >= a) {System.out.println(c);}
        else if (b >= c && b >= a) {System.out.println(b);}
        else {System.out.println(a);}
        }
        }
