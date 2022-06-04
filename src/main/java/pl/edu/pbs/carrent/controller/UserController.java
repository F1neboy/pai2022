package pl.edu.pbs.carrent.controller;

import org.springframework.http.ResponseEntity;
import pl.edu.pbs.carrent.dto.UserUpdateDTO;
import pl.edu.pbs.carrent.model.User;

public interface UserController {
    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<User> updateUser(Long id, UserUpdateDTO user);

}
