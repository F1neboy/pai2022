package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
