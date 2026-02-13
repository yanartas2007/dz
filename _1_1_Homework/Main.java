package _1_1_Homework;

public class Main{
public static void main(String[] args) {

    System.out.println("A");
    ItemStorage<Integer> a = new ItemStorage<>(100);
    a.compareWith(100); // сравнение выдаст true. Оба сравнения - видимо, имеется ввиду == и equals

    System.out.println("B");
    ItemStorage<Integer> b = new ItemStorage<>(200);
    b.compareWith(200); // Сравнение по ссылке выдаст false, так как 200 вне диапазона кэширования

    System.out.println("C");
    ItemStorage<Fraction> c = new ItemStorage<>(new Fraction(1,2));
    c.compareWith(new Fraction(1,2));
}
}


