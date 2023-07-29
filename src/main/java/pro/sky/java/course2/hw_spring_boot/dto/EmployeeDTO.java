package pro.sky.java.course2.hw_spring_boot.dto;

import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.pojo.Position;

import java.util.Objects;
import java.util.Optional;

public class EmployeeDTO {

    private String name;
    private int salary;
    private String position;

    public static EmployeeDTO fromEmployee(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setPosition(Optional.ofNullable(employee.getPosition())
                .map(Position::getName).
                orElse(null));

        return employeeDTO;
    }

    public Employee Employee () {

        Employee employee = new Employee();

        employee.setName(this.getName());
        employee.setSalary(this.getSalary());

        return employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return salary == that.salary && Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, position);

    }
}
