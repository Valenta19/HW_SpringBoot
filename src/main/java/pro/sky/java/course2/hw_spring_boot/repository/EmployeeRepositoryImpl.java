package pro.sky.java.course2.hw_spring_boot.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employees = List.of(new Employee("Charley", 45_000),
            new Employee("Oliver", 75_000),
            new Employee("Jack", 40_000),
            new Employee("Harry", 50_000),
            new Employee("Jacob", 55_000));

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
