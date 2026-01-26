package SEM1.Classwork_Regex.src;
import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "Компания \"Рога и копыта\" основана 15.03.2005.\n" +
                "Контакты: director@roga.ru, support@roga-kopita.com.\n" +
                "Бюджет проекта: 1500000 рублей. Штаб-квартира в Москве.";
        System.out.println("Email-адреса: "); findEmails(str);
        System.out.println("Даты: "); findDates(str);
        System.out.println("Слова с заглавной буквы:"); findCapitalizedWords(str);
        System.out.print("Общее количество цифр: "); countDigits(str);


    }
    public static void findEmails(String text) {
        String[] stroki = sigmaSplit(text); // неэффективно в каждом модуле делить строку на слова, удобнее было бы сделать это 1 раз. Но по тз нужно передавать именно строку
        int count = 1;
        for (String i: stroki) {
            if (i.matches("[a-zA-Z._%+-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,}")) {System.out.print(count++ + ". ");System.out.println(i);}
            else if (i.matches("[a-zA-Z._%+-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,}[.,?!:]{1,2}")) {// также нужно обрабатывать случаи, когда после слова знак препинания
                System.out.print(count++ + ". ");for (int j = 0; j < i.length() - 1; j++) {System.out.print(i.charAt(j));} System.out.println();
            }
        }
    }

    public static void findDates(String text) {
        String[] stroki = sigmaSplit(text); // неэффективно в каждом модуле делить строку на слова, удобнее было бы сделать это 1 раз. Но по тз нужно передавать именно строку
        int count = 1;
        for (String i: stroki) {
            if (i.matches("([0-2][0-9]|3[0-1])\\.(0[1-9]|10|11|12)\\.(19[0-9]{2}|20[0-9]{2})")) {System.out.print(count++ + ". ");System.out.println(i);}
            else if (i.matches("([0-2][0-9]|3[0-1])\\.(0[1-9]|10|11|12)\\.(19[0-9]{2}|20[0-9]{2}[.,?!:]{1,2})")) {// также нужно обрабатывать случаи, когда после слова знак препинания
                System.out.print(count++ + ". ");for (int j = 0; j < i.length() - 1; j++) {System.out.print(i.charAt(j));} System.out.println();
            }
        }
    }

    public static void findCapitalizedWords(String text) { // по тз слова после . не учитываются
        String[] stroki = sigmaSplit(text); // неэффективно в каждом модуле делить строку на слова, удобнее было бы сделать это 1 раз. Но по тз нужно передавать именно строку
        boolean flag = false;
        int count = 1;
        for (String i: stroki) {
            if (flag) {flag = false; continue;}
            if (i.matches("([A-ZА-Я][а-яa-z-]*|)")) {System.out.print(count++ + ". ");System.out.println(i);}
            else if (i.matches("([A-ZА-Я][а-яa-z-]*)[.,?!:]{1,2}")) {// также нужно обрабатывать случаи, когда после слова знак препинания
                System.out.print(count++ + ". ");for (int j = 0; j < i.length() - 1; j++) {System.out.print(i.charAt(j));} System.out.println();
            }
            if (i.charAt(i.length() - 1) == '.') {flag = true;}
        }
    }

    public static void countDigits(String text) {
        int ret = 0;
        String n = "";
        for (int i = 0; i < text.length(); i++) {
            n = "";
            if ((n + text.charAt(i)).matches("[0-9]")) {ret += 1;}
        }
        System.out.println(ret);
    }

    public static String[] sigmaSplit(String str) { // тк split использовать нельзя, делаю аналог, заодно выкидываю "
        int skokSlov = 0;
        str = str + " ";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\t' || str.charAt(i) == '\n') {skokSlov += 1;}
        }
        String[] ret = new String[skokSlov];
        int nSlova = 0;
        String n = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\t' || str.charAt(i) == '\n') {ret[nSlova] = n; n = ""; nSlova += 1;}
            else {if (str.charAt(i) != '"') {n = n + str.charAt(i);}}
        }
        return ret;
    }
}
