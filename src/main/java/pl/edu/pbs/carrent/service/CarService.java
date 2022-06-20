package pl.edu.pbs.carrent.service;

import org.springframework.web.multipart.MultipartFile;
import pl.edu.pbs.carrent.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    List<Car> getCarsBySalon(Long salonId);

    List<Car> getAvailableCarsBySalon(Long salonId);

    List<Car> getAvailableCars();

    Optional<Car> getCarById(Long id);

    Optional<Car> addNewCar(Car car,String localPath, MultipartFile fileName);
    Optional<Car> updateCar(Long id, Car car);

    void deleteCar(Long id);
}
