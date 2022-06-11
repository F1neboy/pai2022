//package pl.edu.pbs.carrent.service.Impl;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import pl.edu.pbs.carrent.model.Role;
//import pl.edu.pbs.carrent.model.RoleName;
//import pl.edu.pbs.carrent.model.User;
//import pl.edu.pbs.carrent.repository.*;
//
//import javax.annotation.PostConstruct;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@AllArgsConstructor
//public class InitService {
//
//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//    private final SalonRepository salonRepository;
//    private final CarRepository carRepository;
//    private final ReservationRepository reservationRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    void init() {
//
//        //add roles to db
//        Role r1 = new Role();
//        r1.setId(1);
//        r1.setName(RoleName.ROLE_USER);
//        Role r2 = new Role();
//        r2.setId(2);
//        r2.setName(RoleName.ROLE_ADMIN);
//        Role r3 = new Role();
//        r3.setId(3);
//        r3.setName(RoleName.ROLE_MODERATOR);
//
//        roleRepository.save(r1);
//        roleRepository.save(r2);
//        roleRepository.save(r3);
//
//        //add users
//        User u1 = new User("test@test.com", "test_u1", "test_u1");
//        u1.setPassword(passwordEncoder.encode(u1.getPassword()));
//        Set<Role> r_u1 = new HashSet<>();
//        r_u1.add(r1);
//        r_u1.add(r2);
//        r_u1.add(r3);
//        u1.setRoles(r_u1);
//
//        userRepository.save(u1);
//
//
//
//    }
//}
