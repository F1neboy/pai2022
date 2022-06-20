package pl.edu.pbs.carrent.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.pbs.carrent.model.Car;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.payload.request.ResultInfo;
import pl.edu.pbs.carrent.repository.CarRepository;
import pl.edu.pbs.carrent.service.CarService;
import pl.edu.pbs.carrent.service.FileUploadService;
import pl.edu.pbs.carrent.service.SalonService;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final FileUploadService fileUploadService;
    private final SalonService salonService;


    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarsBySalon(Long salonId) {
        Salon salon = salonService.getSalonById(salonId).orElseThrow(NoSuchElementException::new);
        return carRepository.findCarsBySalon(salon);
    }

    @Override
    public List<Car> getAvailableCarsBySalon(Long salonId) {
        Salon salon = salonService.getSalonById(salonId).orElseThrow(NoSuchElementException::new);
        return carRepository.findCarsBySalonAndAvailable(salon, true);
    }

    @Override
    public List<Car> getAvailableCars() {
        return carRepository.findCarsByAvailable(true);
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }


    @Override
    public Optional<Car> addNewCar(Car car, String localPath, MultipartFile fileName) {

        ResultInfo resultInfo;
        try {
            resultInfo = fileUploadService.fileUpload(localPath, car.getModel(), fileName.getOriginalFilename());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        car.setImageLink(resultInfo.getPathFile()+fileName.getOriginalFilename());

        return Optional.of(carRepository.save(car));
    }
    @Override
    public Optional<Car> updateCar(Long id, Car car) {
        Car newCar = carRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if(car.getAvailable() != null) {
            newCar.setAvailable(car.getAvailable());
        }
        if(car.getSalon() != null) {
            newCar.setSalon(car.getSalon());
        }
        if(car.getModel() != null) {
            newCar.setModel(car.getModel());
        }
        if(car.getBrand() != null) {
            newCar.setBrand(car.getBrand());
        }
        if(car.getDescription() != null) {
            newCar.setDescription(car.getDescription());
        }
        if(car.getImageLink() != null) {
            newCar.setImageLink(car.getImageLink());
        }
        return Optional.of(carRepository.save(newCar));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
