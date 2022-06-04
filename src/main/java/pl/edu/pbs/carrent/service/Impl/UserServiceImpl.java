package pl.edu.pbs.carrent.service.Impl;

import lombok.AllArgsConstructor;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.dto.UserUpdateDTO;
import pl.edu.pbs.carrent.model.User;
import pl.edu.pbs.carrent.repository.UserRepository;
import pl.edu.pbs.carrent.service.UserService;
import pl.edu.pbs.carrent.service.utils.PasswordUtils;


import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(Long id, UserUpdateDTO updatedUser) {
        User user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
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
