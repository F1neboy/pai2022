package pl.edu.pbs.carrent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
