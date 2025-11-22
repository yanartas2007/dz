package Homework_String;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String predl = sc.nextLine();

        int skokclov = 1;
        for (int i = 0; i < predl.length(); i++) {if (predl.charAt(i) == ' ') {skokclov += 1;}}
        char[][] slova = new char[skokclov][predl.length()];

        int nomerslova = 0;
        int nomerb = 0;
        int nomermaxslova = 0;
        int maxvovels = 0;
        int vovels = 0;
        char b = ' ';
        for (int i = 0; i < predl.length(); i++) {
            b = predl.charAt(i);
            slova[nomerslova][nomerb] = b;
            if (b == ' ' || i == predl.length() - 1) {if (vovels > maxvovels) {
                maxvovels = vovels;
                nomermaxslova = nomerslova;
            }nomerslova += 1; nomerb = 0; vovels=0;}
            nomerb += 1;
            if (isvovel(b)) {vovels += 1;}
        }
        for (int i = 1; i < predl.length(); i++) {
            b = slova[nomermaxslova][i];
            System.out.print(b);
            if (b == ' ') {break;}
        }
    }



    public static boolean isvovel(char b) {
        String vovels = "ёуеыаоэяиюЁУЕЫАОЭЯИЮ";
        for (int i = 0; i < vovels.length(); i++) {
            if (vovels.charAt(i) == b) {return true;}
        }
        return false;
    }
}
