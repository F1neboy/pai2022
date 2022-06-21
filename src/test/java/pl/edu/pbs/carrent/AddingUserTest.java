package pl.edu.pbs.carrent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.edu.pbs.carrent.model.Role;
import pl.edu.pbs.carrent.model.RoleName;
import pl.edu.pbs.carrent.model.User;
import pl.edu.pbs.carrent.repository.RoleRepository;
import pl.edu.pbs.carrent.repository.UserRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class AddingUserTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private  PasswordEncoder passwordEncoder;



    @Test
    void contextLoads() {

        Role r1 = new Role();
        r1.setId(1);
        r1.setName(RoleName.ROLE_USER);
        Role r2 = new Role();
        r2.setId(2);
        r2.setName(RoleName.ROLE_ADMIN);
        Role r3 = new Role();
        r3.setId(3);
        r3.setName(RoleName.ROLE_MODERATOR);
        Role r4 = new Role();
        r4.setId(4);
        r4.setName(RoleName.ROLE_EMPLOYEE);

        roleRepository.save(r1);
        roleRepository.save(r2);
        roleRepository.save(r3);
        roleRepository.save(r4);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


        User u20 = new User("Kamila", "Jackowska", "Kamila.jac.b@interia.pl", "619812241", "Nowogrodzka 15 Warszawa", Date.valueOf(LocalDate.parse("11-12-1993", formatter)), "kamila15", "knkasggsa2");
        u20.setPassword(passwordEncoder.encode(u20.getPassword()));
        Set<Role> r_u20 = new HashSet<>();
        r_u20.add(r1);
        u20.setRoles(r_u20);
        userRepository.save(u20);
    }
}
