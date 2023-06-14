package pro.sky.java.course2.hw_spring_boot.service;

import pro.sky.java.course2.hw_spring_boot.dto.EmployeeDTO;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Double getSalarySum();

    Optional<Integer> getMinSalary();

    Optional<Integer> getMaxSalary();

    List<Employee> getAllEmployeesWithSalaryHigherThenAvg();

    List<Employee> addEmployee(Employee employee);

    List<Employee> updateEmployee(Employee employee);

    List<EmployeeDTO> getEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<EmployeeDTO> getAllEmployeesWithSalaryHigherThan(int salary);

    List<EmployeeDTO> getAllEmployeesWithMatchingPosition(String position);

    List<EmployeeDTO> getEmployeeFullInfo(int id);

    List<EmployeeDTO> getEmployeesInPageFormat(int page);
}
