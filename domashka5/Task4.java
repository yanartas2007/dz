package domashka5;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n2 = 1;
        for (int i = 0; i < n; i++) {n2 *= 10; System.out.print('a');} // тк a это 0, а числа с 0 не начинаются, тут костыль
        System.out.println();
        for (int i = n2 / 100; i < n2 / 10; i++) {System.out.println(inttostring(i) + "a ");}
        for (int i = n2 / 10; i < n2; i++) {System.out.println(inttostring(i) + " ");}
    }
    public static String inttostring(int n) {
        String b = "аеёиоуыэюя";
        String ret = "";
        while (n > 0) {
            ret = ret + b.charAt(n % 10);
            n /= 10;
        }
        return ret;
    }
}
