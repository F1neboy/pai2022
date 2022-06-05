package pl.edu.pbs.carrent.service;

import pl.edu.pbs.carrent.model.Salon;

import java.util.Optional;

public interface SalonService {

    Optional<Salon> getSalonById(Long id);
}
