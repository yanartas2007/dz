package SEM1.Homework_ООП_Студенты;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private int age;
    private double averageGrade;
    private String faculty;
    private static int totalStudents = 0;
    private final String UNIVERSITY_NAME = "КФУ";

    public Student(String studentId,String firstname, String lastname, int age, double averageGrade, String faculty) {
        setStudentId(studentId);
        setFirstName(firstname);
        setLastName(lastname);
        setAge(age);
        setAverageGrade(averageGrade);
        setFaculty(faculty);
        totalStudents++;
        StudentManager.addStudent(this);
    }

    public Student(String studentId, String firstName, String lastName) {
        this(studentId, firstName, lastName, 0, 0.0, "NO_FACULITY");
    }

    public Student() {
        this("NO_ID", "NO_NAME", "NO_LASTNAME");
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public String displayInfo() {
        return "Студент " + firstName + " " + lastName + " " + studentId;
    }

    public String displayInfo(boolean detailed) {
        if (detailed) {return "Студент " + firstName + " " + lastName + " " + studentId
                + "\n" + faculty + " " + UNIVERSITY_NAME + " Возраст: " + age + " Балл: " + averageGrade;}
        else {return displayInfo();}
    }

    public void updateGrade(double newGrade) {
        setAverageGrade(newGrade);
    }

    public void updateGrade(double newGrade, String subject) {
        System.out.println(subject);
        setAverageGrade(newGrade);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        assert studentId.length() > 0;
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        assert age > 16 && age < 70;
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        assert averageGrade >= 0.0 && averageGrade <= 5.0;
        this.averageGrade = averageGrade;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
