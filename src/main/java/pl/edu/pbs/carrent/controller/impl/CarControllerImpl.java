package pl.edu.pbs.carrent.controller.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pbs.carrent.controller.CarController;
import pl.edu.pbs.carrent.model.Car;
import pl.edu.pbs.carrent.service.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class CarControllerImpl implements CarController {

    private final CarService carService;

    @Override
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(carService.getCars());
    }

    @Override
    @GetMapping("/cars/salon/{salonId}")
    public ResponseEntity<List<Car>> getCarsBySalon(@PathVariable Long salonId) {
        return ResponseEntity.ok(carService.getCarsBySalon(salonId));
    }

    @Override
    @GetMapping("/cars/salon/{salonId}/available")
    public ResponseEntity<List<Car>> getAvailableCarsBySalon(@PathVariable Long salonId) {
        return ResponseEntity.ok(carService.getAvailableCarsBySalon(salonId));
    }

    @Override
    @GetMapping("/cars/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAvailableCars());
    }

    @Override
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.of(carService.getCarById(id));
    }

    @Override
    @PatchMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.of(carService.updateCar(id, car));
    }

    @Override
    @PostMapping("/cars")
    public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
        return ResponseEntity.of(carService.addNewCar(car));
    }

    @Override
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
