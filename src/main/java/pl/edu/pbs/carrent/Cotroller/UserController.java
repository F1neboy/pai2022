package pl.edu.pbs.carrent.Cotroller;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.DTO.UserUpdateDTO;
import pl.edu.pbs.carrent.Model.Users;

public interface UserController {
    ResponseEntity<Users> getUserById(Long id);

    ResponseEntity<Users> updateUser(Long id, UserUpdateDTO user);

}
