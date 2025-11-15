package domashka6_Regex.Classwork_Regex_2.src;

import java.util.regex.*;

public class Task5{
    public static void main(String[] args) {
        String text = "Сегодня был в #парке и #кино #отдых #выходные"; // ОТКУДА ; ???????
        text = ";" + text + ';';
        Pattern pattern = Pattern.compile("#[^ ]*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}