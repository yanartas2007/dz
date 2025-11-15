package domashka8_inkapsulation_OOPstudents.students;

public class Course {
    private String courseCode;
    private String courseName;
    private int maxStudents;
    private int currentStudents;
    private boolean isActive;
    private Student[] list; // удобнее хранить так
    private static int totalCourses = 0;
    private static final int MAX_CREDITS_PER_SEMESTER = 10; // если не static, не получается использовать в static методе

    public Course(String courseCode, String courseName, int maxStudents, int currentStudents, boolean isActive) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setMaxStudents(maxStudents);
        setCurrentStudents(currentStudents);
        setIsActive(isActive);
        totalCourses++;
        StudentManager.addCourse(this);
    }

    public Course(String courseCode, String courseName) {
        this(courseCode, courseName, 0, 0, false);
    }

    public Course() {
        this("NO_CODE", "NO_NAME");
    }

    public void enrollStudent() {
        setCurrentStudents(getCurrentStudents() + 1);
    }

    public void enrollStudent(Student student) { // не вижу смысла передавать studentId, здесь же нет бд, можно передать сразу объект.
        setCurrentStudents(getCurrentStudents() + 1);
        list[currentStudents - 1] = student;
    }

    public String displayInfo() {
        return "Курс " + courseName + " " + courseCode + " Студентов " + currentStudents + "/" + maxStudents + ' ' + isActive;
    }

    public String displayInfo(boolean detailed) {
        String ret = displayInfo() + "\n";
        if (currentStudents > 0) {
        for (Student student: list) { if (student != null) {
            ret = ret + student.displayInfo() + '\n';
        }}}
        return ret;
    }

    public static boolean calculateWorkload(int credits) {
        return MAX_CREDITS_PER_SEMESTER >= credits;
    }

    public static int getTotalCourses() {
        return totalCourses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
        Student[] newStudents = new Student[maxStudents];
        int i = 0;
        if (currentStudents > 1) {
        for (Student student: list) {
            if (i < maxStudents) {newStudents[i] = student; i++;} else {break;}
        }}
        this.list = newStudents;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public int getCurrentStudents() {
        return currentStudents;
    }

    public void setCurrentStudents(int currentStudents) {
        assert currentStudents <= maxStudents;
        this.currentStudents = currentStudents;
    }

    public Student[] getList() {
        return list;
    }

    public void setList(Student[] list) {
        this.list = list;
    }

}
