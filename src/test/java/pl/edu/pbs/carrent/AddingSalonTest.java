package pl.edu.pbs.carrent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pbs.carrent.model.Salon;
import pl.edu.pbs.carrent.repository.SalonRepository;

public class AddingSalonTest {
    @Autowired
    private SalonRepository salonRepository;
    @Test
    void contextLoads() {
        Salon s4 = salonRepository.save(new Salon(0l, "Wroclaw", "Jablkowa 112"));
        salonRepository.save(s4);
    }
}
