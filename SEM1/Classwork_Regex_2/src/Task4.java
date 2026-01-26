package SEM1.Classwork_Regex_2.src;

import java.util.regex.*;

public class Task4{
    public static void main(String[] args) {
        String text =  "Вика,18,Альметьевск;Анна,24,Казань;Аскар,6,Бугульма";
        Pattern pattern = Pattern.compile("[^;]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}