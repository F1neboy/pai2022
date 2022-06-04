package pl.edu.pbs.carrent.service;

import pl.edu.pbs.carrent.dto.UserUpdateDTO;
import pl.edu.pbs.carrent.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    Optional<User> updateUser(Long id, UserUpdateDTO user);
}
