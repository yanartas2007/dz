package _1_6_Classwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> al = new ArrayList<>();
        al.add(new Student("Аслав", 50.0, 7));
        al.add(new Student("Аслав", 100.0, 9));
        al.add(new Student("Бслав", 60.0, 8));
        al.add(new Student("Гслав", 50.0, 3));
        al.add(new Student("Бслав", 50.0, 4));
        al.add(new Student("Дслав", 50.0, 5));
        al.add(new Student("Ыслав", 50.0, 7));

        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);

        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        al.sort(c);
        System.out.println(al);

        Iterator<Student> it = al.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getMissedClasses() > 5) {
                it.remove();
            }
        }
        System.out.println(al);
    }
}