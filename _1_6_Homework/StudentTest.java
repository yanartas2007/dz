package _1_6_Homework;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StudentTest {
    ArrayList<Student> al = new ArrayList<>();
    String[] names = {"Загон Баранов", "Ушат Помоев", "Удел Злодеев", "Аслав", "Бслав", "Вслав", "Гслав", "Питер Паркер",
            "Би Хан", "Чак Норрис", "Артур Пирожков", "Якупов Риналь", "Остап Бендер", "Гуссейнов Мурад", "Саб зиро", "Скорпион",
            "Марио", "Луиджи", "Бенедикт Кембербетч", "Морган Фримен", "Жан клод Ван-Дам", "Роберт Дениро", "Леонардо Дикаприо",
            "Дженсен Эклз", "Джаред Падалеки", "Мистер картофельная голова", "Экран", "Свинка пеппа", "Крош", "Форест Гамп",
            "Люк Скайуокер", "Дарт Вейдер", "Микелянджело", "Хонсу", "Граф Дракула", "Граф Монтекристо", "Антон Чигур",
            "Джонни Силверхенд", "Майк вазовски", "Осел", "Шрек", "Чип и Дейл", "Джек Воробей", "Оптимус Прайм", "Мегатрон",
            "Альтрон", "Пудж", "Вижн", "Гендальф", "Пакман", "Стив"}; // я придумывал имена дольше, чем писал код 😀

    @BeforeEach
    public void before() {
        Random r = new Random(42);
        for (int i = 0; i < 100; i++) {
            al.add(new Student(names[Math.abs(r.nextInt() % names.length)], r.nextDouble(), r.nextInt()));
        }
        al.get(15).setMissedClasses(7); // для проверок надо чтобу у некоторых совпадало количество пропусков, а вероятность того что выпадет в рандоме минимальна
        al.get(25).setMissedClasses(7);
    }

    @Test
    public void testComparable() {
        Collections.sort(al);
        for (Student i: al) {
            Assertions.assertTrue(al.getFirst().compareTo(i) <= 0);
        }
        for (int i = 0; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                if (al.get(i).getMissedClasses() == al.get(j).getMissedClasses()) {
                    Assertions.assertTrue(al.get(i).getRating() <= al.get(j).getRating());
                }
            }
        }
    }

    @Test
    public void testUtilityCoomparator() {
        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getRating() * 0.7 - (double) o1.getMissedClasses(), o2.getRating() * 0.7 - (double) o2.getMissedClasses());
            }
        };
        al.sort(c);
        for (int i = 0; i < 99; i++) {
//            System.out.println("" + (al.get(i).getRating() * 0.7 - (double) al.get(i).getMissedClasses()) +" "+ (al.get(i+1).getRating() * 0.7 - (double) al.get(i+1).getMissedClasses()));
            Assertions.assertTrue(al.get(i).getRating() * 0.7 - (double) al.get(i).getMissedClasses() <= al.get(i+1).getRating() * 0.7 - (double) al.get(i+1).getMissedClasses());
        }
    }

    @Test
    public void testIteratorLogic() {
        ArrayList<Student> badStudents = new ArrayList<>();
        Iterator<Student> it = al.iterator();
        int removecount = 0;
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getRating() < 2.0) {
                if (s.getMissedClasses() <= 15) {
                badStudents.add(s);
                }
                it.remove();
                removecount++;
            }
        }
        for (Student i: al) {
            Assertions.assertTrue(i.getRating() >= 2.0);
        }

        Assertions.assertEquals(100-removecount, al.size());

        for (Student i: badStudents) {
            Assertions.assertTrue(i.getRating() < 2.0 && i.getMissedClasses() <= 15);
        }
    }
}
