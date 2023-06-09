package pro.sky.java.course2.hw_spring_boot.repository;

import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
   List<Employee> addEmployee(Employee employees);

    List<Employee> updateEmployee(Employee employee, int id);

    Optional<Employee> getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
