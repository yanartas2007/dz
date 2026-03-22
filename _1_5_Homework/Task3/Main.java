package _1_5_Homework.Task3;

public class Main {
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        generateFeed(new MyArrayList<String>(), 100000);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        generateFeed(new MyDoubleLinkedList<String>("first"), 100000);
        System.out.println(System.currentTimeMillis() - start);

        // разница в 3-4 раза.
    }

    public static void generateFeed(MyList<String> al, int amount) {
        for (int i = 0; i < amount; i++) {
             al.add(0, "item");
        }
    }
}
