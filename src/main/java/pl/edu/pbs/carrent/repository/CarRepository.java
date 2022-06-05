package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Car;
import pl.edu.pbs.carrent.model.Salon;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsBySalon(Salon salon);

    List<Car> findCarsBySalonAndAvailable(Salon salon, boolean available);

    List<Car> findCarsByAvailable(boolean available);
}
