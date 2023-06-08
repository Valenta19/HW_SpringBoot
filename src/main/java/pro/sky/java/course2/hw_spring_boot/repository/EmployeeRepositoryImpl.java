package pro.sky.java.course2.hw_spring_boot.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employees = List.of(new Employee( 1,"Charley", 45_000),
            new Employee(2,"Oliver", 75_000),
            new Employee(3,"Jack", 40_000),
            new Employee(4,"Harry", 50_000),
            new Employee(5,"Jacob", 55_000));
    private final HashMap<Integer, Employee> employeeDelete = new HashMap<>();
    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        List<Employee> list = new ArrayList<>(employees);
        list.add(employee);

    }

    @Override
    public List<Employee> updateEmployee(Employee employee, int id) {
        return employees.stream()
                .filter(employees1 -> employee.getId() == id)
                .peek(employees1 -> employee.setId(employees1.getId()))
                .peek(employees1 -> employee.setName(employee.getName()))
                .peek(employees1 -> employee.setSalary(employee.getSalary()))
                .toList();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {

        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeDelete.remove(id);
    }
}
