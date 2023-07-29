package pro.sky.java.course2.hw_spring_boot.constans;

import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.List;

public class EmployeeConstans {
    public static final Employee employee = new Employee();
    public static final Employee employee1 = new Employee();
    public static final Employee employee2 = new Employee();

    public static final List<Employee> EMPLOYEE = List.of(
            employee,
            employee1,
            employee2);
}
