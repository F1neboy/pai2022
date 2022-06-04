package pl.edu.pbs.carrent.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.model.User;
import pl.edu.pbs.carrent.repository.UserRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getItemsList(){
        return userRepo.findAll();
    }
    public Optional<User> addUser(User user){
        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  Optional.of(userRepo.save(user));

    }
    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }

}
