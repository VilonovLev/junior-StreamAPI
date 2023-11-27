package org.example;


import java.util.List;
import java.util.Map;


/**
 * 0.1. Посмотреть разные статьи на Хабр.ру про Stream API
 * 0.2. Посмотреть видеоролики на YouTube.com Тагира Валеева про Stream API
 *
 * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * 1.1 Найти максимальное
 * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 *
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> randomNumbers = UtilFunctions.getRandomNumbers(1,1_000_000,1_000);
        System.out.println(randomNumbers);
        System.out.println("Max in list: " + UtilFunctions.max(randomNumbers));
        System.out.println("Result first function: " + UtilFunctions.firstFunctionEvaluation(randomNumbers));
        System.out.println("Result second function: " + UtilFunctions.secondFunctionEvaluation(randomNumbers));;

        List<Employee> employees = EmployeeServices.fetchEmployees(15);
        System.out.println(employees);
        EmployeeServices.printAllDepartments(employees);
        EmployeeServices.salaryIndexation(employees,10_000,20);
        System.out.println(employees);

        Map<String,List<Employee>> listMap = EmployeeServices.fetchEmployeesByDepartments(employees);
        System.out.println(listMap);

        Map<String,Double> departments = EmployeeServices.fetchAverageSalaryByDepartments(employees);
        System.out.println(departments);

    }


}