package pro.sky.java.course2.hw_spring_boot.service;

import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Double getSalarySum();

    Optional<Integer> getMinSalary();

    Optional<Integer> getMaxSalary();

    List<Employee> getAllEmployeesWithSalaryHigherThenAvg();

    void addEmployee(Employee employee);

    List<Employee> updateEmployee(Employee employee, int id);

    Optional<Employee> getEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<Employee> allEmployeesWithHigherSalaries(int salary);
}
