package pro.sky.java.course2.hw_spring_boot.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.java.course2.hw_spring_boot.dto.EmployeeDTO;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Double getSalarySum();

    Optional<Integer> getMinSalary();

    List<Employee> getMaxSalary();

    List<Employee> getAllEmployeesWithSalaryHigherThenAvg();

    List<Employee> addEmployee(Employee employee);

    List<Employee> updateEmployee(Employee employee);

    List<EmployeeDTO> getEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<EmployeeDTO> getAllEmployeesWithSalaryHigherThan(int salary);

    List<EmployeeDTO> getAllEmployeesWithMatchingPosition(String position);

    Optional<EmployeeDTO> getEmployeeFullInfo(int id);

    List<EmployeeDTO> getEmployeesInPageFormat(int page);
    void saveEmployeeFromJson(MultipartFile file) throws IOException;
}
