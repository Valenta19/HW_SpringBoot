package pro.sky.java.course2.hw_spring_boot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import pro.sky.java.course2.hw_spring_boot.dto.EmployeeDTO;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;
import pro.sky.java.course2.hw_spring_boot.repository.EmployeeRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.hw_spring_boot.constans.EmployeeConstans.EMPLOYEE;
import static pro.sky.java.course2.hw_spring_boot.constans.EmployeeConstans.employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository mockRepository;

    @InjectMocks
    private EmployeeServiceImpl out;

    private static final Page<Employee> employeeInPageFormat = new PageImpl<>(EMPLOYEE);

    @Test
    public void shouldReturnCollectionOfAllEmployees() {
        out.getAllEmployees();
        when(mockRepository.getAllEmployees()).thenReturn(EMPLOYEE);
        assertIterableEquals(EMPLOYEE, out.getAllEmployees());
    }

    @Test
    public void shouldReturnSalarySum() {
        out.getSalarySum();
        Double testSalary = Double.valueOf(EMPLOYEE.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum));

        assertEquals(testSalary, out.getSalarySum());
    }

    @Test
    public void shouldReturnMinSalary() {
        out.getMinSalary();
        Optional<Integer> testMinSalary = EMPLOYEE.stream()
                .map(Employee::getSalary)
                .min(Comparator.naturalOrder());

        assertTrue(testMinSalary.isPresent());
    }

    @Test
    public void shouldReturnMaxSalary() {
        out.getMaxSalary();
        Optional<Integer> testMaxSalary = EMPLOYEE.stream()
                .map(Employee::getSalary)
                .max(Comparator.naturalOrder());

        assertTrue(testMaxSalary.isPresent());
    }

    @Test
    public void shouldReturnEmployeesWithSalaryHigherThenAvg() {
        out.getAllEmployeesWithSalaryHigherThenAvg();
        List<Employee> list = EMPLOYEE.stream()
                .filter(employee -> employee.getSalary() > mockRepository.getSalarySum() / EMPLOYEE.size())
                .toList();

        assertIterableEquals(list, out.getAllEmployeesWithSalaryHigherThenAvg());
    }

    @Test
    public void shouldAddEmployee() {
        Employee employee1 = new Employee();
        out.addEmployee(employee1);
        verify(mockRepository, times(1)).save(employee1);
    }

    @Test
    public void shouldUpdateEmployee() {
        Employee employee1 = new Employee();
        employee1.setName("name");
        out.updateEmployee(employee1);
        verify(mockRepository, times(1)).save(employee1);
    }

    @Test
    public void shouldDeleteEmployee() {
        out.deleteEmployeeById(1);
        verify(mockRepository, times(1)).deleteById(1);
    }

    @Test
    public void shouldReturnAllEmployeesWithSalaryHigherThan() {
        int salary = 10000;
        out.getAllEmployeesWithSalaryHigherThan(salary);
        List<Employee> list = EMPLOYEE.stream()
                .filter(employee -> employee.getSalary() > salary)
                .toList();
        assertIterableEquals(list, out.getAllEmployeesWithSalaryHigherThan(salary));
    }

    @Test
    public void shouldReturnAllEmployeesWithMatchingPosition() {
        int position = 1;
        out.getAllEmployeesWithMatchingPosition(Integer.toString(position));
        List<Employee> list = EMPLOYEE.stream()
                .filter(employee -> employee.getPositionId() == position)
                .toList();
        assertIterableEquals(list, out.getAllEmployeesWithMatchingPosition(Integer.toString(position)));
    }

    @Test
    public void shouldReturnEmployeesInPageFormat() {
        when(mockRepository.findAll(PageRequest.of(0, 10)))
                .thenReturn(employeeInPageFormat);
        assertEquals(3, out.getEmployeesInPageFormat(0).size());
    }

    @Test
    public void shouldReturnEmployeeFullInfo() {
        Optional<EmployeeDTO> employee1 = EMPLOYEE.stream()
                .map(EmployeeDTO::fromEmployee)
                .findFirst();
        when(mockRepository.findById(3))
                .thenReturn(Optional.of(employee));
        assertEquals(employee1, out.getEmployeeFullInfo(3));
    }

    @Test
    public void shouldSaveEmployeeFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(EMPLOYEE);
        MockMultipartFile file = new MockMultipartFile("employees", "employees.json", MediaType.MULTIPART_FORM_DATA_VALUE, json.getBytes());
        out.saveEmployeeFromJson(file);
    }

}