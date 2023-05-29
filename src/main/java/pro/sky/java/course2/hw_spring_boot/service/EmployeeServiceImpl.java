package pro.sky.java.course2.hw_spring_boot.service;
import org.springframework.stereotype.Service;

import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getAllEmployees();
    }

    @Override
    public Double getSalarySum() {
        return employeeRepository.getAllEmployees().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Optional<Integer> getMinSalary() {
        return employeeRepository.getAllEmployees().stream()
                .map(Employee::getSalary)
                .min(Comparator.naturalOrder());
    }

    @Override
    public Optional<Integer> getMaxSalary() {

        return employeeRepository.getAllEmployees().stream()
                .map(Employee::getSalary)
                .max(Comparator.naturalOrder());
    }

    @Override
    public List<Employee> getAllEmployeesWithSalaryHigherThenAvg() {
        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > getSalarySum() / employeeRepository.getAllEmployees().size())
                .toList();
    }
}