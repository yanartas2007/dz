package SEM1.Classwork_Regex_2.src;

import java.util.regex.*;

public class Task1{
    public static void main(String[] args) {
        String text = "Она сказала: \"Привет!\", а он ответил: \"Как дела?\", \n" +
                "потом: \"Отлично!\"";
        Pattern pattern = Pattern.compile("\".*?\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}