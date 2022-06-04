package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
