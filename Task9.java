import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int k = scanner.nextInt();
        int summ = 0;
        while (k != 0) {summ += k - k / 10 * 10;
        k /= 10;}
        System.out.println(summ);
        }
        }

