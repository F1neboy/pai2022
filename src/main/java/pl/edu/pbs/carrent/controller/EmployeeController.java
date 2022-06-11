package pl.edu.pbs.carrent.controller;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.model.Employee;

import java.util.List;

public interface EmployeeController {

    ResponseEntity<List<Employee>> getEmployees();

    ResponseEntity<Employee> getEmployeeById(Long id);

    ResponseEntity<List<Employee>> getEmployeesBySalonId(Long salonId);

    ResponseEntity<Employee> addNewEmployee(Employee employee);

    void deleteEmployee(Long id);

}
