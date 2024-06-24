package ivan.zver.kur.service;

import ivan.zver.kur.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Optional<Employee> putEmployeeById(Long id, Employee updatedEmployee);

    void deleteEmployeeById(Long id);
}
