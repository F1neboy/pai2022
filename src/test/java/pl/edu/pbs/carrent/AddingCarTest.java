package pl.edu.pbs.carrent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddingCarTest {
    private final CarRepository carRepository;

    

    @Test
    void contextLoads() {
        Car car = new Car("Modus","2012 - brazowy","Renault", null, s1, true);
        carRepository.save(car);
    }


}
