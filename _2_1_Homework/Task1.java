package _2_1_Homework;

import java.util.function.Consumer;
import java.util.function.Function;

public class Task1 {
    public static void main(String[] args) {
        Function<String, Function<String, Consumer<String>>> carrirovannaya_f =
                token -> chatid -> new Consumer<String>() {
                    @Override
                    public void accept(String s) {

                    }

                    @Override
                    public Consumer<String> andThen(Consumer<? super String> after) {
                        return Consumer.super.andThen(after);
                    }
                };
        Consumer<String> myNotifier = carrirovannaya_f.apply("token").apply("chatid");
        processOrder("item", myNotifier);

    }

    public static void processOrder(String item, Consumer<String> sender) {
        sender.accept(item);
    }
}
