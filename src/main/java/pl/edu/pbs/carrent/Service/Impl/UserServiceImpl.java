package pl.edu.pbs.carrent.Service.Impl;

import lombok.AllArgsConstructor;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.DTO.UserUpdateDTO;
import pl.edu.pbs.carrent.Model.Users;
import pl.edu.pbs.carrent.Repository.UserRepository;
import pl.edu.pbs.carrent.Service.UserService;
import pl.edu.pbs.carrent.Service.utils.PasswordUtils;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private PasswordEncoder passwordEncoder;

    private PasswordUtils passwordUtils;

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Users> updateUser(Long id, UserUpdateDTO updatedUser) {
        Users user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        if (updatedUser.getUsername() != null) {
            user.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getEmail() != null) {
            user.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        return Optional.of(userRepository.save(user));
    }




}
