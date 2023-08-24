package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.hw_spring_boot.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService
            employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("/salary/all")
//    public List<Employee> All() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/salary/sum")
//    public Double Sum() {
//        return employeeService.getSalarySum();
//    }
//
//    @GetMapping("/salary/min")
//    public Optional<Integer> Min() {
//        return employeeService.getMinSalary();
//    }
//
//    @GetMapping("/high-salary")
//    public List<Employee> highSalary() {
//        return employeeService.getAllEmployeesWithSalaryHigherThenAvg();
//    }
//
//    @GetMapping("/{id}")
//    public List<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//
//    @GetMapping("/salaryHigher")
//    public List<EmployeeDTO> salaryHigherThan(@RequestParam("salary") Integer salary) {
//        return employeeService.getAllEmployeesWithSalaryHigherThan(salary);
//    }
//
//    @GetMapping("withHighestSalary")
//    public List<Employee> showMax() {
//        return employeeService.getMaxSalary();
//    }
//
//    @GetMapping("/position")
//    public List<EmployeeDTO> getEmployeesForPosition(@RequestParam("position") String position) {
//        return employeeService.getAllEmployeesWithMatchingPosition(position);
//    }
//
//    @GetMapping("/{id}/fullInfo")
//    public Optional<EmployeeDTO> getEmployeeFullInfo(@PathVariable int id) {
//
//        return employeeService.getEmployeeFullInfo(id);
//    }
//
//    @GetMapping("/page")
//    public List<EmployeeDTO> getEmployeesInPageFormat(@RequestParam(required = false, defaultValue = "0") int page) {
//
//        return employeeService.getEmployeesInPageFormat(page);
//
//    }
//    @PostMapping("/add")
//    public List<Employee> Add(@RequestBody Employee employee) {
//        return employeeService.addEmployee(employee);
//    }

}
