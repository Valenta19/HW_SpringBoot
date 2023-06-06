package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.service.EmployeeService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("get/{id}")
    public List<Employee>getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public List<Employee>  Add(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("update/{id}")
    public List<Employee> EditEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return employeeService.updateEmployee(employee,id);
    }

    @DeleteMapping("delete/{id}")

    public List<Employee> DeleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployeeById(id);
    }
    @GetMapping("/salaryHigher")
    public List<Employee> salaryHigherThan(@RequestParam("salary") Integer salary) {
        return employeeService.allEmployeesWithHigherSalaries(salary);
    }

}
