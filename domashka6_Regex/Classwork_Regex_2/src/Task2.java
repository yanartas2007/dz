package domashka6_Regex.Classwork_Regex_2.src;

import java.util.regex.*;

public class Task2{
    public static void main(String[] args) {
        String text =  """ 
    [ERROR] 2024-01-15: Connection failed
    [INFO] 2024-01-15: User logged in
    [DEBUG] 2024-01-15: Processing request
    [ERROR] 2024-01-15: Database timeout
     """;
        Pattern pattern = Pattern.compile("\\[ERROR].+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}