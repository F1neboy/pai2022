package pl.edu.pbs.carrent.service;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.model.Salon;

import java.util.List;
import java.util.Optional;

public interface SalonService {

    Optional<Salon> getSalonById(Long id);

    List<Salon> getSalons();

    Optional<Salon> updateSalon(Long id, Salon salon);

    Optional<Salon> addNewSalon(Salon salon);

    void deleteSalon(Long id);
}
