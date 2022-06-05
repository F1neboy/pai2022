package pl.edu.pbs.carrent.controller;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.model.Car;

import java.util.List;

public interface CarController {

    ResponseEntity<List<Car>> getCars();

    ResponseEntity<List<Car>> getCarsBySalon(Long salonId);

    ResponseEntity<List<Car>> getAvailableCarsBySalon(Long salonId);

    ResponseEntity<List<Car>> getAvailableCars();

    ResponseEntity<Car> getCarById(Long id);

    ResponseEntity<Car> updateCar(Long id, Car car);

    ResponseEntity<Car> addNewCar(Car car);

    void deleteCar(Long id);
}
