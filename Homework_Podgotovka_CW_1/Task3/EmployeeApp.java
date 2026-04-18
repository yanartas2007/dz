package Homework_Podgotovka_CW_1.Task3;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeApp {
    public static void main(String[] args) {
        List<Department> departments = DataGenerator_Task3.generateDepartments();
        List<Employee> employers = DataGenerator_Task3.generateEmployees();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int command = sc.nextInt();
            if (command == 0) break;

            switch (command) {
                case 1:
                    employers.stream()
                            .map(e -> {
                                String deptName = departments.stream()
                                        .filter(d -> d.getId() == e.getDepartmentId())
                                        .findFirst().map(Department::getName).orElse("Unknown");
                                return e.getName() +" "+ e.getAge()+" "+ deptName+" "+ e.getSalary();
                            })
                            .forEach(System.out::println);
                    break;

                case 2:
                    Map<String, Double> salaryFond = employers.stream()
                            .collect(Collectors.groupingBy(
                                    e -> departments.stream()
                                            .filter(d -> d.getId() == e.getDepartmentId())
                                            .findFirst().map(Department::getName).orElse("нет ниче"),
                                    Collectors.summingDouble(Employee::getSalary)
                            ));
                    salaryFond.forEach((dept, fund) -> System.out.println(dept + " -> " + fund));
                    break;

                case 3:
                    employers.stream()
                            .filter(e -> e.getAge() < 35)
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .limit(3)
                            .forEach(e -> System.out.println(e.getName() + " - " + e.getSalary()));
                    break;

                case 4:
                    employers.stream()
                            .max(Comparator.comparingDouble(Employee::getSalary))
                            .ifPresent(e -> System.out.println("Макс зарплата: " + e.getName() + e.getSalary()));
                    break;

                case 5:
                    Map<Integer, String> empToDept = employers.stream()
                            .collect(Collectors.toMap(
                                    Employee::getId,
                                    e -> departments.stream()
                                            .filter(d -> d.getId() == e.getDepartmentId())
                                            .findFirst().map(Department::getName).orElse("нет ниче")
                            ));
                    empToDept.forEach((id, dept) -> System.out.println(id + " : " + dept));
                    break;

                case 6:
                    Map<Department, List<Employee>> departmentToWorkers = employers.stream()
                            .collect(Collectors.groupingBy(e ->
                                    departments.stream()
                                            .filter(d -> d.getId() == e.getDepartmentId())
                                            .findFirst().orElse(null)
                            ));
                    List<String> allNames = departmentToWorkers.values().stream()
                            .flatMap(List::stream)
                            .map(Employee::getName)
                            .collect(Collectors.toList());
                    System.out.println("Все имена: " + allNames);
                    break;

            }
        }
    }
}