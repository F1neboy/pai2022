package pl.edu.pbs.carrent.controller;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.model.Employee;
import pl.edu.pbs.carrent.model.Reservation;
import pl.edu.pbs.carrent.model.ReservationState;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationController {

    ResponseEntity<List<Reservation>> getReservations();

    ResponseEntity<List<Reservation>> getReservationBySalonStart(Long salonId);

    ResponseEntity<List<Reservation>> getReservationBySalonEnd(Long salonId);

    ResponseEntity<List<Reservation>> getReservationByUser(Long userId);

    ResponseEntity<Reservation> getReservation(Long id);

    ResponseEntity<Reservation> addReservation(Reservation reservation);

    ResponseEntity<Reservation> updateReservationStatus(Long id, ReservationState reservationState);

    ResponseEntity<Reservation> updateEndDate(Long id, Date end_date);


    ResponseEntity<Reservation> endReservation(Long id, Employee employee);

    void deleteReservation(Long id);
}
