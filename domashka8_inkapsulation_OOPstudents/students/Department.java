package domashka8_inkapsulation_OOPstudents.students;

public class Department {
    private String departmentName;
    private String headOfDepartment;
    private String email;
    private String phoneNumber;
    private double budget;
    private static int totalDepartments;
    private final int UNIVERSITY_BUDGET = 1000000;

    public Department(String departmentName, String headOfDepartment, String email, String phoneNumber, double budget) {
        setDepartmentName(departmentName);
        setHeadOfDepartment(headOfDepartment);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setBudget(budget);
        totalDepartments++;
        StudentManager.addDepartment(this);
    }

    public Department(String departmentName) {
        this(departmentName, "HEAD_OF_DEPARTMENT", "email@domen.ru", "000", 0.0);
    }

    public Department() {
        this("NO_NAME");
    }

    public String contact() {
        return email + ' ' + phoneNumber;
    }

    public String displayInfo() {
        return this.departmentName;
    }

    public String contact(String message) {
        System.out.println(message);
        return contact();
    }

    public void allocateBudget(double amount) {
        setBudget(budget - amount);
    }

    public void allocateBudget(double amount, String purpose) {
        allocateBudget(amount);
        System.out.println(purpose);
    }

    public static boolean validateEmail(String email) {
        return email.matches("[a-zA-Z._%+-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,}");
    }

    public static int getTotalDepartments() {
        return totalDepartments;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        assert validateEmail(email);
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        assert phoneNumber.matches("[0-9]*");
        this.phoneNumber = phoneNumber;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        assert budget >= 0;
        this.budget = budget;
    }

}
