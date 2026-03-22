package _1_5_Homework.Task2;

public class GeneratorData {
    public static String[] returnData() {
        int rplus = (int) Math.random() * 100;
        int dublicat = 100000 - (int) Math.random() * 1000;
        String[] massive = new String[100000];
        for (int i = 0; i < 100000; i++) {
            String s = "";
            s = s + (char) (i + rplus);
            massive[i] = s;
            if (i == dublicat) {
                massive[i] = massive[i - (int) Math.random() * 10];
            }
        }
        return massive;
    }
}
