package _2_1_Homework;

import java.util.function.Function;

public class Task2 {
    public static void main(String[] args) {
        Function<String, String> trimmer = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.strip();
            }
        };
        Function<String, String> toLower = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        };
        Function<String, String> firstUpper = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.replaceFirst(""+s.charAt(0), (""+s.charAt(0)).toUpperCase());
            }
        };
        Function<String, String> fullClean = trimmer.andThen(toLower.andThen(firstUpper));
        Function<String, String> quickClean = trimmer.andThen(toLower);

    }
}
