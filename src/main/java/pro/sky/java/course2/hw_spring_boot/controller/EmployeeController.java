package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.hw_spring_boot.dto.EmployeeDTO;
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
    public Optional<Integer> max() {
        return employeeService.getMaxSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> highSalary() {
        return employeeService.getAllEmployeesWithSalaryHigherThenAvg();
    }

    @GetMapping("/{id}")
    public List<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public List<Employee> Add(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }


    @PutMapping("/{id}")
    public List<Employee> editEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")

    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/salaryHigher")
    public List<EmployeeDTO> salaryHigherThan(@RequestParam("salary") Integer salary) {
        return employeeService.getAllEmployeesWithSalaryHigherThan(salary);
    }

    @GetMapping("withHighestSalary")
    public Optional<Integer> showMax() {
        return employeeService.getMaxSalary();
    }

    @GetMapping("/position")
    public List<EmployeeDTO> getEmployeesForPosition(@RequestParam("position") String position) {
        return employeeService.getAllEmployeesWithMatchingPosition(position);
    }

    @GetMapping("/{id}/fullInfo")
    public List<EmployeeDTO> getEmployeeFullInfo(@PathVariable int id) {

        return employeeService.getEmployeeFullInfo(id);
    }

    @GetMapping("/page")
    public List<EmployeeDTO> getEmployeesInPageFormat(@RequestParam(required = false,defaultValue = "0") int page) {

        return employeeService.getEmployeesInPageFormat(page);

    }
}
