package pl.edu.pbs.carrent.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.model.Employee;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.repository.EmployeeRepository;
import pl.edu.pbs.carrent.service.EmployeeService;
import pl.edu.pbs.carrent.service.SalonService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SalonService salonService;

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesBySalonId(Long salonId) {
        Salon salon = salonService.getSalonById(salonId).orElseThrow(NoSuchElementException::new);
        return employeeRepository.findAllBySalonEmployee(salon);
    }

    @Override
    public Optional<Employee> addNewEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
