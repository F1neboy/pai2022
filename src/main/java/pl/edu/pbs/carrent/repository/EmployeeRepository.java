package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Employee;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.model.User;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllBySalonEmployee(Salon salon);

    Optional<Employee> findByUser(User user);
}
