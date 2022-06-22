package pl.edu.pbs.carrent.service;

import pl.edu.pbs.carrent.model.Employee;
import pl.edu.pbs.carrent.model.Reservation;
import pl.edu.pbs.carrent.model.ReservationState;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getReservations();

    List<Reservation> getReservationBySalonStart(Long salonId);

    List<Reservation> getReservationBySalonEnd(Long salonId);

    List<Reservation> getReservationByUser(Long userId);

    Optional<Reservation> addReservation(Reservation reservation);

    Optional<Reservation> getReservationById(Long id);

    Optional<Reservation> updateReservationStatus(Long id, ReservationState reservationState);

    Optional<Reservation> updateEndDate(Long id, Date end_date);

    Optional<Reservation> endReservation(Long id, Employee employee);


    void deleteReservation(Long id);



}
