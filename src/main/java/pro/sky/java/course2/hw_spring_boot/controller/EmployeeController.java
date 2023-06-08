package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService
            employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/salary/all")
    public List<Employee> all() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/sum")
    public Double sum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/salary/min")
    public Optional<Integer> min() {
        return employeeService.getMinSalary();
    }

    @GetMapping("/salary/max")
    public Optional<Integer> max() {
        return employeeService.getMaxSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> highSalary() {
        return employeeService.getAllEmployeesWithSalaryHigherThenAvg();
    }

    @GetMapping("/{id}")
    public Optional<Employee>getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody Employee employee) {
         employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public List<Employee> editEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return employeeService.updateEmployee(employee,id);
    }

    @DeleteMapping("/{id}")

    public void deleteEmployee(@PathVariable Integer id) {
       employeeService.deleteEmployeeById(id);
    }
    @GetMapping("/salaryHigher")
    public List<Employee> salaryHigherThan(@RequestParam("salary") Integer salary) {
        return employeeService.allEmployeesWithHigherSalaries(salary);
    }

}
