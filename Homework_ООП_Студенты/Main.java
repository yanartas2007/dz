package Homework_ООП_Студенты;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("id1", "Иван", "Иваныч");
        Student s2 = new Student("id2", "Петр", "Петрович");
        Student s3 = new Student();

        for (Student s: StudentManager.getStudents()) {System.out.println(s.displayInfo(true) + "\n");}

        Course c1 = new Course("1", "Сварщик");
        c1.setMaxStudents(10);
        Course c2 = new Course("2", "Юрист");
        c2.setMaxStudents(10);
        Department d1 = new Department("Кафедра сварщиков и юристов");

        StudentManager.addStudentToCourse(s1, c1);
        System.out.println(c1.displayInfo(true) + '\n');

        System.out.println(StudentManager.findStudentById("id1").displayInfo() + '\n');
    }
}
