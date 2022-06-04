package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Salon;

public interface SalonRepository extends JpaRepository<Salon, Long> {
}
