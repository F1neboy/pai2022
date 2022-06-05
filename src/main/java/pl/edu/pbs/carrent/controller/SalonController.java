package pl.edu.pbs.carrent.controller;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.model.Salon;

import java.util.List;

public interface SalonController {

    ResponseEntity<List<Salon>> getSalons();

    ResponseEntity<Salon> getSalonById(Long id);

    ResponseEntity<Salon> updateSalon(Long id, Salon salon);

    ResponseEntity<Salon> addNewSalon(Salon salon);

    void deleteSalon(Long id);

}
