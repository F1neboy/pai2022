package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Reservation;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.model.User;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationsBySalonStart(Salon salon);

    List<Reservation> findReservationsByUserReservation(User user);

    List<Reservation> findReservationsBySalonEnd(Salon salon);

    Reservation findReservationById(Long id);
}
