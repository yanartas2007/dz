package domashka6_Regex.Classwork_Regex_2.src;

import java.util.regex.*;

public class Task3{
    public static void main(String[] args) {
        String text =   """
    <div class="product">
        <h3>Телефон</h3>
        <p>Цена: 20000 руб</p>
    </div>
    <div class="product">
        <h3>Ноутбук</h3>
        <p>Цена: 50000 руб</p>
    </div>
    """;
        Pattern pattern = Pattern.compile("<h3>.*?</h3>");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}