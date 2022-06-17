package pl.edu.pbs.carrent.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.model.Reservation;
import pl.edu.pbs.carrent.model.ReservationState;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.model.User;
import pl.edu.pbs.carrent.repository.ReservationRepository;
import pl.edu.pbs.carrent.service.ReservationService;
import pl.edu.pbs.carrent.service.SalonService;
import pl.edu.pbs.carrent.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final SalonService salonService;

    private final UserService userService;

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationBySalonStart(Long salonId) {
        Salon salon = salonService.getSalonById(salonId).orElseThrow(NoSuchElementException::new);
        return reservationRepository.findReservationsBySalonStart(salon);
    }

    @Override
    public List<Reservation> getReservationBySalonEnd(Long salonId) {
        Salon salon = salonService.getSalonById(salonId).orElseThrow(NoSuchElementException::new);
        return reservationRepository.findReservationsBySalonEnd(salon);
    }

    @Override
    public List<Reservation> getReservationByUser(Long userId) {
        User user = userService.getUserById(userId).orElseThrow(NoSuchElementException::new);
        return reservationRepository.findReservationsByUserReservation(user);
    }

    @Override
    public Optional<Reservation> addReservation(Reservation reservation) {
        return Optional.of(reservationRepository.save(reservation));
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Optional<Reservation> updateReservationStatus(Long id, ReservationState reservationState) {
        Reservation reservation=reservationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        reservation.setState(reservationState);
        return Optional.of(reservationRepository.save(reservation));
    }

    @Override
    public Optional<Reservation> updateEndDate(Long id, Date end_date) {
        Reservation reservation=reservationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        reservation.setEndDate(end_date);
        return Optional.of(reservationRepository.save(reservation));
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
