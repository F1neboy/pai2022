package pl.edu.pbs.carrent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.pbs.carrent.model.Car;
import pl.edu.pbs.carrent.repository.CarRepository;

@SpringBootTest
class AddingCarTest {
    @Autowired
    private  CarRepository carRepository;

    

    @Test
    void contextLoads() {
        Car car = new Car(0l,"Modus","2012 - brazowy","Renault", null, null, true);
        carRepository.save(car);
    }


}
