package pl.edu.pbs.carrent.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pbs.carrent.controller.ReservationController;
import pl.edu.pbs.carrent.model.Car;
import pl.edu.pbs.carrent.model.Reservation;
import pl.edu.pbs.carrent.model.ReservationState;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.service.Impl.ReservationServiceImpl;
import pl.edu.pbs.carrent.service.ReservationService;

import java.util.Date;
import java.util.List;

public class ReservationControllerImpl implements ReservationController {

    private ReservationService reservationService;

    @Override
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        return ResponseEntity.ok(reservationService.getReservations());
    }

    @Override
    @GetMapping("/reservations/salon/start/{salonId}")
    public ResponseEntity<List<Reservation>> getReservationBySalonStart(@PathVariable Long salonId) {
        return ResponseEntity.ok(reservationService.getReservationBySalonStart(salonId));
    }

    @Override
    @GetMapping("/reservations/salon/end/{salonId}")
    public ResponseEntity<List<Reservation>> getReservationBySalonEnd(@PathVariable Long salonId) {
        return ResponseEntity.ok(reservationService.getReservationBySalonEnd(salonId));
    }

    @Override
    @GetMapping("/reservations/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reservationService.getReservationByUser(userId));
    }

    @Override
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.of(reservationService.getReservationById(id));
    }

    @Override
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation, @RequestBody Car car) {
        Reservation reservation1=reservation;
        reservation1.setCar_reservation(car);
        return ResponseEntity.of(reservationService.addReservation(reservation1));
    }

    @Override
    @PatchMapping("/reservation/{id}")
    public ResponseEntity<Reservation> updateReservationStatus(@PathVariable Long id, @RequestBody ReservationState reservationState) {
        return ResponseEntity.of(reservationService.updateReservationStatus(id, reservationState));
    }

    @Override
    @PatchMapping("/reservation/{id}")
    public ResponseEntity<Reservation> updateEndDate(@PathVariable Long id, @RequestBody Date end_date) {
        return ResponseEntity.of(reservationService.updateEndDate(id, end_date));
    }

    @Override
    @DeleteMapping("/reservation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(Long id) {
        reservationService.deleteReservation(id);
    }
}
