package pl.edu.pbs.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.model.Reservation;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.model.User;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationBySalon_start(Salon salon);

    List<Reservation> findReservationByUser_reservation(User user);

    List<Reservation> findReservationBySalon_end(Salon salon);
}
