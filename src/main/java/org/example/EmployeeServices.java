package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeServices {
    private static final String[] NAMES = {"Игорь", "Жанна", "Фёдор", "Иван", "Константин", "Женя"};
    private static final String[] DEPARTMENTS = {"HR", "Буxгалтерия", "АХО", "IT"};
    private static final Random RANDOM = new Random();

    //2.1 Создать список из 10-20 сотрудников
    public static List<Employee> fetchEmployees(int countEmployee) {
        List<Employee> employees = Stream.generate(Employee::new)
                .limit(countEmployee)
                .collect(Collectors.toList());
        employees.forEach(x -> {
            x.setName(NAMES[RANDOM.nextInt(NAMES.length)]);
            x.setAge(RANDOM.nextInt(18,65));
            x.setSalary(RANDOM.nextInt(8_000,15_000));
            x.setDepartment(DEPARTMENTS[RANDOM.nextInt(DEPARTMENTS.length)]);
        });

        return employees;
    }

    //2.2 Вывести список всех различных отделов (department) по списку сотрудников
    public static void printAllDepartments(List<Employee> employees) {
        System.out.println(employees.stream().map(Employee::getDepartment).distinct().toList());
    }

    //2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
    public static void salaryIndexation(List<Employee> employees, double limiter, double percentageIncrease) {
        employees.stream().filter(x -> x.getSalary() < limiter)
                .forEach(x -> upSalary(x, percentageIncrease));
    }

    private static void upSalary(Employee employee, double percent) {
        double salaryIncrease = (percent * employee.getSalary())/100;
        employee.setSalary(employee.getSalary() + salaryIncrease);
    }

    //2.4 * Из списка сотрудников с помощью стрима создать
    //Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
    public static Map<String,List<Employee>> fetchEmployeesByDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    //2.5 * Из списока сорудников с помощью стрима создать
    // Map<String, Double> с отделами и средней зарплатой внутри отдела
    public static Map<String,Double> fetchAverageSalaryByDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
    }

}



