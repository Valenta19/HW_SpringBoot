package pro.sky.java.course2.hw_spring_boot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.java.course2.hw_spring_boot.dto.EmployeeDTO;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.repository.EmployeeRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Double getSalarySum() {
        return employeeRepository.getSalarySum();
    }

    @Override
    public Optional<Integer> getMinSalary() {
        return employeeRepository.getMinSalary();
    }

    @Override
    public List<Employee> getMaxSalary() {
        return employeeRepository.getMaxSalary();
    }

    @Override
    public List<Employee> getAllEmployeesWithSalaryHigherThenAvg() {
        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > getSalarySum() / employeeRepository.getAllEmployees().size())
                .toList();
    }

    @Override
    public List<Employee> addEmployee(Employee employee) {
        return (List<Employee>) employeeRepository.save(employee);
    }


    @Override
    public List<Employee> updateEmployee(Employee employee) {
        return Collections.singletonList(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDTO> getEmployeeById(int id) {

        return employeeRepository.findById(id).stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesWithSalaryHigherThan(int salary) {
        return employeeRepository.getAllEmployeesWithSalaryHigherThan(salary).stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesWithMatchingPosition(String position) {
        return employeeRepository.getAllEmployeesWithMatchingPosition(position).stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeeFullInfo(int id) {
        return employeeRepository.findById(id).stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());

    }

    @Override
    public List<EmployeeDTO> getEmployeesInPageFormat(int page) {
        return employeeRepository.findAll(PageRequest.of(page, 10)).stream()
                .map((Object employee) -> EmployeeDTO.fromEmployee((Employee) employee))
                .collect(Collectors.toList());
    }

    @Override
    public void saveEmployeeFromJson(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Employee> employees = objectMapper.readValue(file.getBytes(), new TypeReference<>() {
        });
        employeeRepository.saveAll(employees);
    }


}