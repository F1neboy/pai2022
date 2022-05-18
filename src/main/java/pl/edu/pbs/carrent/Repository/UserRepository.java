package pl.edu.pbs.carrent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.carrent.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
