package _1_5_Homework.Task2;


import _1_5_Homework.Task1.MyHashSet;

public class Main {
    public static void main(String[] args) {
        String[] data = GeneratorData.returnData();

        // 1
        double start = System.currentTimeMillis();
        MyArrayList<String> al = new MyArrayList<>(data);
        for (int i = 0; i < al.getSize(); i++) {
            if (al.indexOf(al.get(i)) != i) {
                System.out.println(al.get(i));
                break;
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println();

        // 2
        start = System.currentTimeMillis();
        MyHashSet<String> hs = new MyHashSet<>();
        for (int i = 0; i < al.getSize(); i++) {
            if (!hs.add(data[i])) {
                System.out.println(data[i]);
                break;
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println();


        // время различается в +-530 раз!

    }
}
