package domashka6_Regex;
import java.util.Scanner;

public class UserValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name.matches("[А-Я][а-я]{1,14}"));
    }
}
