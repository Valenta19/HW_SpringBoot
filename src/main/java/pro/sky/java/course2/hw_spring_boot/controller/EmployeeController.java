package pro.sky.java.course2.hw_spring_boot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/salary/all")
    public List<Employee> All() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/sum")
    public Double Sum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/salary/min")
    public Optional<Integer> Min() {
        return employeeService.getMinSalary();
    }

    @GetMapping("/salary/max")
    public Optional<Integer> Max() {
        return employeeService.getMaxSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> highSalary() {
        return employeeService.getAllEmployeesWithSalaryHigherThenAvg();
    }
}
