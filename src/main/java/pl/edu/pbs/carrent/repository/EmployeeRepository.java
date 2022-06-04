package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
