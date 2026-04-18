package Homework_Podgotovka_CW_1.Task3;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private int departmentId;

    public Employee(int id, String name, int age, double salary, int departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public int getDepartmentId() { return departmentId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', age=" + age +
                ", salary=" + salary + ", departmentId=" + departmentId + "}";
    }
}