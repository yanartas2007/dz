package _1_1_Homework;

public class Main{
public static void main(String[] args) {

    System.out.println("A");
    ItemStorage<Integer> a = new ItemStorage<>(100);
    a.compareWith(100); // из за кеширования оба сравнения true

    System.out.println("Б");
    ItemStorage<Integer> b = new ItemStorage<>(200);
    b.compareWith(200); // Сравнение по ссылке выдаст false, так как 200 вне диапазона кэширования

    System.out.println("В");
    ItemStorage<Fraction> c = new ItemStorage<>(new Fraction(1,2));
    System.out.println(c.getValue().equals(new Fraction(1,2))); // equals выдаст true, так как переопределен и знаяения равны
}
}


