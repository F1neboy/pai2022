package pl.edu.pbs.carrent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.pbs.carrent.model.Car;

import java.util.List;

public interface CarController {

    ResponseEntity<List<Car>> getCars();

    ResponseEntity<List<Car>> getCarsBySalon(Long salonId);

    ResponseEntity<List<Car>> getAvailableCarsBySalon(Long salonId);

    ResponseEntity<List<Car>> getAvailableCars();

    ResponseEntity<Car> getCarById(Long id);

    ResponseEntity<Car> updateCar(Long id, Car car);

    ResponseEntity<Car> addNewCar(String carJson, MultipartFile fileName);

    void deleteCar(Long id);
}
