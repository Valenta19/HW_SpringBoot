package pro.sky.java.course2.hw_spring_boot.service;
import org.springframework.stereotype.Service;

import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.repository.EmployeeRepository;

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
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Integer getSalarySum() {
        return employeeRepository.getSalarySum();
    }

    @Override
    public Optional<Integer> getMinSalary() {
        return employeeRepository.getMinSalary();
    }

    @Override
    public Optional<Integer> getMaxSalary() {
        return employeeRepository.getMaxSalary();
    }

    @Override
    public List<Employee> getAllEmployeesWithSalaryHigherThenAvg() {
        return employeeRepository.getAllEmployeesWithSalaryHigherThenAvg();
    }
}