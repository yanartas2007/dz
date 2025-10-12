package domashka5;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n2 = 1;
        for (int i = 0; i < n; i++) {n2 *= 10;}

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
