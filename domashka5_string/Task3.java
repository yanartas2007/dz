package domashka5_string;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dlina = sc.nextInt();
        int v = sc.nextInt();
        String input = "";
        sc.nextLine();
        boolean[] stolb = new boolean[dlina];
        for (int y = 0; y < v; y++) {
            for (int x = 0; x < dlina; x++) {
                input = sc.nextLine();
                if (isvovel(input.charAt(input.length() - 1))) {
                   stolb[x] = true;
                }
            }
        }
        boolean flag = true;
        for (boolean b: stolb) {
            if (!b) {flag = false; break;}
        }
        System.out.println(flag);
    }

    public static boolean isvovel(char b) {
        String vovels = "ёуеыаоэяиюЁУЕЫАОЭЯИЮ";
        for (int i = 0; i < vovels.length(); i++) {
            if (vovels.charAt(i) == b) {return true;}
        }
        return false;
    }
}
