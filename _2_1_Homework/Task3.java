package _2_1_Homework;

import java.util.function.Predicate;

public class Task3 {
    public static void main(String[] args) {
        Predicate<String> isShort = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 5;
            }
        };
        Predicate<String> hasSpam = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("buy");
            }
        };
        Predicate<String> isCaps = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals(s.toUpperCase());
            }
        };
        Predicate<String> checkComment = isCaps.negate().and(isCaps.or(hasSpam));
        System.out.println(checkComment.test("rehtrjsyjsyjy"));
        System.out.println(checkComment.test("pqehfpoefhewop"));
        System.out.println(checkComment.test("buy"));
        System.out.println(checkComment.test("IIII"));
    }
}
