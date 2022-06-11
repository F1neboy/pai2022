package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Employee;
import pl.edu.pbs.carrent.model.Salon;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllBySalonEmployee(Salon salon);
}
