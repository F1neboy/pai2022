package pl.edu.pbs.carrent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.Model.Salons;

public interface SalonsRepository extends JpaRepository<Salons, Long> {
}
