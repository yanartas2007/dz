package SEM1.TextStatistica;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextStatistica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = """
                Разработать программу, которая анализирует произвольный текст и вычисляет статистику
                Требования к статистике:
                1 Статистика слов
                Общее количество слов
                Количество уникальных слов
                Самое длинное слово
                какоетооченьдлинннннннноеслово
                2 Статистика чисел
                Найти все щисла (целые и десятичные)
                Найти суммы продаж (числа с символом $)
                какие то суммы продаж $3 $2.5.
                Найти среднее значение чисел
                3 Статистика контактов
                Найти все email-адреса
                kakoitoemail@kakoitodomen.chtoto
                Найти все номера телефонов
                +1(111)11-11-11-11
                4 Статистика символов
                Общее количество символов
                Количество букв, цифр, пробелов
                Количество специальных символов
                5 Статистика предложений
                Количество предложений
                Средняя длина предложений.
                Какое - то предложение. Еще что то умное! И еще?""";
        slova(text);
        System.out.println();
        chisla(text);
        System.out.println();
        contact(text);
        System.out.println();
        simvol(text);
        System.out.println();
        predlozgenie(text);

    }
    public static void slova(String text) {
        Pattern pattern = Pattern.compile("\\(?[А-Яа-я-]+[.,?!;)]?"); // слова
        Matcher matcher = pattern.matcher(text);
        int skokslov = 0;
        int nomer1 = 0;
        int raznuxslov = 0;
        int maxlength = 0;
        String maxslovo = "";
        while (matcher.find()) {
            String slovo = matcher.group();
            skokslov += 1;
            Matcher matcher2 = pattern.matcher(text);
            int nomer2 = 0;
            boolean flag = true;
            while (matcher2.find()) {if (nomer1 != nomer2 && eqvivalentno(slovo, matcher2.group())) {flag = false; break;} nomer2+=1;}
            if (flag) {raznuxslov += 1;}
            nomer1 += 1;
            if (slovo.length() > maxlength) {maxlength = slovo.length(); maxslovo = slovo;}
        }
        System.out.println("Всего слов " + skokslov);
        System.out.println("Разных слов " + raznuxslov);
        System.out.println("Самое длинное слово(первое найденное) <<" + maxslovo + ">> его длина аж " + maxlength + "🤯🤯🤯😱😱😱🙀🙀🙀");
    }
    public static void chisla(String text) {
        Pattern pattern = Pattern.compile("[0-9]+\\.?[0-9]*[.,!?:]?");
        Matcher matcher = pattern.matcher(text);
        double summa = 0;
        double kolichestvo = 0;
        System.out.println("Числа всякие");
        while (matcher.find()) {
            String chislo = matcher.group();
            summa += double_from_string(chislo);
            kolichestvo++;
            System.out.println(chislo);
        }

        pattern = Pattern.compile("\\$[0-9]+\\.?[0-9]*[.,!?:]?");
        matcher = pattern.matcher(text);
        System.out.println("из низ суммы продаж всякие");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("Средннее всех чисел:" + summa / kolichestvo);
    }
    public static void contact(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z._%+-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,}[.,?!:]{0,2}");
        Matcher matcher = pattern.matcher(text);
        System.out.println("e-mailы всякие");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        pattern = Pattern.compile("\\+?[0-9-()]{3,}");
        matcher = pattern.matcher(text);
        System.out.println("телефоны чьи-то");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    public static void simvol(String text) {
        System.out.println("Всего символов " + text.length());
        int b = 0;
        int c = 0;
        int p = 0;
        int s = 0;
        for (int j = 0; j < text.length(); j++) {
            String i = "" + text.charAt(j);
            if (i.matches("[a-zA-Zа-яА-Я]")) {b++;}
            else if (i.matches("\\d")) {c++;}
            else if (i.matches("[\\s]")) {p++;}
            else {s++;}
        }
        System.out.println("Букв " + b);
        System.out.println("Цифр " + c);
        System.out.println("Пробельных символов " + p);
        System.out.println("Другое " + s);
    }
    public static void predlozgenie(String text) {
        Pattern pattern = Pattern.compile("[A-ZА-Я][^!.?]{2,}");
        Matcher matcher = pattern.matcher(text + ".");
        int kolichestvo = 0;
        while (matcher.find()) {
            kolichestvo += 1;
        }
        System.out.println("Всего предложений " + kolichestvo);
        System.out.println("В среднем, в предложении столько букв " + (text.length() / kolichestvo));
    }


    public static boolean eqvivalentno(String a, String b) { // сравнение двух строк
        if (a.length() != b.length()) {return false;}
        for (int i = 0; i < a.length(); i++) {if (a.charAt(i) != b.charAt(i)) {return false;}}
        return true;

    }
    public static double double_from_string(String str) { // делаем из строки щисло. подразумевается что число >= 0
        double ret = 0.0;
        boolean est_tochka = false;
        double mnojitel = 1.0;
        for (int j = 0; j < str.length(); j++) {
            char i = str.charAt(j);
            if (i == '.') {
                est_tochka = true;
            } else {
                int digit = i - '0';
                if (!est_tochka) {
                    ret = ret * 10 + digit;
                } else {
                    mnojitel *= 10;
                    ret += digit / mnojitel;
                }
            }
        }

        return ret;
    }
}
