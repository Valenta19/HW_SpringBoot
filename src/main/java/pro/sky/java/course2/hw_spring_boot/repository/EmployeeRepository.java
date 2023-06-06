package pro.sky.java.course2.hw_spring_boot.repository;

import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();

    List<Employee> addEmployee(Employee employee);

    List<Employee> updateEmployee(Employee employee, int id);

    List<Employee> getEmployeeById(int id);

    List<Employee> deleteEmployeeById(int id);
}
