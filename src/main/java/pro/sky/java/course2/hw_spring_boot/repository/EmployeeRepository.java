package pro.sky.java.course2.hw_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employees",
            nativeQuery = true)
    List<Employee> getAllEmployees();

    @Query(value = "SELECT SUM(salary) " +
            "FROM employees",
            nativeQuery = true)
    Integer getSalarySum();

    @Query(value = "SELECT MIN(salary) " +
            "FROM employees", nativeQuery = true)
    Optional<Integer> getMinSalary();

    @Query(value = "SELECT MAX(salary) " +
            "FROM employees", nativeQuery = true)
    Optional<Integer> getMaxSalary();

    @Query(value = "SELECT * FROM employees " +
            "WHERE salary >(SELECT AVG (salary) FROM employees)",
            nativeQuery = true)
    List<Employee> getAllEmployeesWithSalaryHigherThenAvg();

    @Query(value = "SELECT * FROM employees " +
            "WHERE salary > :salary",
            nativeQuery = true)
    List<Employee> getAllEmployeesWithSalaryHigherThan(@Param("salary") int salary);

    @Query(value = "SELECT employees.id, employees.name, employees.salary, employees.position_id FROM employees " +
            "INNER JOIN position " +
            "ON employees.position_id = position.id and position.name = :name",
            nativeQuery = true)
    List<Employee> getAllEmployeesWithMatchingPosition(@Param("name") String name);

}
