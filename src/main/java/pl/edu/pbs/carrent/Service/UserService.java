package pl.edu.pbs.carrent.Service;

import pl.edu.pbs.carrent.DTO.UserUpdateDTO;
import pl.edu.pbs.carrent.Model.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> getUserById(Long id);
    Optional<Users> updateUser(Long id, UserUpdateDTO user);
//    Optional<Users> addNewUser(Users users);




}
