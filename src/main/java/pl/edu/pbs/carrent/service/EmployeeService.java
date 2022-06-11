package pl.edu.pbs.carrent.service;

import pl.edu.pbs.carrent.model.Employee;
import pl.edu.pbs.carrent.model.Salon;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getEmployees();

    List<Employee> getEmployeesBySalonId(Long salonId);

    Optional<Employee> addNewEmployee(Employee employee);

    void deleteEmployee(Long id);
}
