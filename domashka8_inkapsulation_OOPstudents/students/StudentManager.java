package domashka8_inkapsulation_OOPstudents.students;

public class StudentManager {
    private static Course[] courses;
    private static Department[] departments;
    private static Student[] students;

    public static void addStudent(Student student) {
        int i = 0;
        Student[] st2 = new Student[Student.getTotalStudents()];
        if (Student.getTotalStudents() > 1) {
        for (Student st: students) {
            st2[i] = st; i++;
        }}
        st2[i] = student;
        students = st2;
    }

    public static void addDepartment(Department department) {
         int i = 0;
         Department[] st2 = new Department[Department.getTotalDepartments()];
         if (Department.getTotalDepartments() > 1) {
         for (Department d: departments) {st2[i] = d; i++;}}
         st2[i] = department;
         departments = st2;
    }

    public static void addCourse(Course course) {
        int i = 0;
        Course[] st2 = new Course[Course.getTotalCourses()];
        if (Course.getTotalCourses() > 1) {
        for (Course d: courses) {st2[i] = d; i++;}}
        st2[i] = course;
        courses = st2;

    }

    public static void addStudentToCourse(Student student, Course course) {
        course.enrollStudent(student);
    }

    public static Student findStudentById(String studentId) {
        for (Student i: students) {
            if (i.getStudentId().equals(studentId)) {return i;}
        }
        throw new AssertionError(); // если не найден, вызывается ошибка
    }

    public static Student[] getStudentsByFaculty(String faculty) {
        int studentsInFaculty = 0;
        for (Student i: students) {
            if (i.getFaculty().equals(faculty)) {studentsInFaculty++;}
        }
        Student[] ret = new Student[studentsInFaculty];
        int n = 0;
        for (Student i: students) {
            if (i.getFaculty().equals(faculty)) {ret[n]=i; n++;}
        }
        return ret;
    }

    public static double calculateFacultyAverage(String faculty) {
        Student[] fstudents = getStudentsByFaculty(faculty);
        double ret = 0;
        int n = 0;
        for (Student s: fstudents) {ret += s.getAverageGrade(); n++;}
        return ret / n;
    }

    public static Student[] getStudents() {return students;}

    public static Department[] getDepartments() {return departments;}

    public static Course[] getCourses() {return courses;}
}
