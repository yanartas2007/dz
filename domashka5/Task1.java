package domashka5;
// import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "A roza upala na lapu azora";

        char[] str2 = new char[str.length()]; // без всяких не букв и буквы в нижнем регистре
        int probeluvconce = 0;

        for (int i = 0; i < str.length(); i++) {
            char n = preobrazovanie(str.charAt(i));
            if (n != '#') {str2[i - probeluvconce] = n;} else {probeluvconce += 1;}
        }

        char[] str3 = new char[str.length() - probeluvconce];
        for (char i = 0; i < str.length() - probeluvconce; i++) {str3[i] = str2[i];} // без пробелов в конце

        char[] str_3 = new char[str.length() - probeluvconce];
        for (int i = str.length() - probeluvconce - 1; i > -1; i--) {str_3[str.length() - probeluvconce - 1 - i] = str3[i];}

//        System.out.println(Arrays.toString(str2));
//        System.out.println(Arrays.toString(str3));
//        System.out.println(Arrays.toString(str_3));

        boolean flag = true;
        for (char i = 0; i < str.length() - probeluvconce; i++) {if (str3[i] != str_3[i]) {flag=false;break;}}
        System.out.println(flag);
    }

    public static char preobrazovanie(char a) {
        String vsemelkiebukvi = "qwertyuiopasdfghjklzxcvbnmёйцукенгшщзхъфывапролджэячсмитьбю";
        String vsebolshiebukvi = "QWERTYUIOPASDFGHJKLZXCVBNMЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
        for (int i = 0; i < vsebolshiebukvi.length(); i++) {
            if (a == vsemelkiebukvi.charAt(i)) {return a;}
            if (a == vsebolshiebukvi.charAt(i)) {return vsemelkiebukvi.charAt(i);}
        }
        return '#'; // знак что там ничего нет
    }
}
