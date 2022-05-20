package pl.edu.pbs.carrent.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.Model.Users;
import pl.edu.pbs.carrent.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Users> getItemsList(){
        return userRepo.findAll();
    }
    public Optional<Users> addUser(Users user){
        user.setEmail(user.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  Optional.of(userRepo.save(user));

    }
    public Optional<Users> getUserById(Long id){
        return userRepo.findById(id);
    }

}
