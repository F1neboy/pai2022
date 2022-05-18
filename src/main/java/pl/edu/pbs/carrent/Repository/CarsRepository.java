package pl.edu.pbs.carrent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.Model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {
}
