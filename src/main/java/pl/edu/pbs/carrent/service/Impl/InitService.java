package pl.edu.pbs.carrent.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.model.Role;
import pl.edu.pbs.carrent.model.RoleName;
import pl.edu.pbs.carrent.model.User;
import pl.edu.pbs.carrent.repository.*;
//
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class InitService {
//
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final SalonRepository salonRepository;
    private final CarRepository carRepository;
    private final ReservationRepository reservationRepository;

    private final PasswordEncoder passwordEncoder;
//
    @PostConstruct
    void init() {
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
          User u2 = new User("Andrzej","Nowak","andrzej.n@wp.pl","504930194","Kwiatowa 14 Bydgoszcz","12-05-1999","andrzejnowak","98fniasni8x!");
          Set<Role> r_u2 = new HashSet<>();
          r_u2.add(r1);

          User u3 = new User("Michał","Kowalski","michalk123@o2.pl","501850185","Orzechowa 30 Bydgoszcz","19-01-1989","michal123","micj293k*");
          Set<Role> r_u3 = new HashSet<>();
          r_u3.add(r1);

          User u4 = new User("Ewa","Kot","ewakot3@gmail.com","789104940","Grunwaldzka 19/3 Bydgoszcz","24-12-1980","ewakot55","mirnai321)");
          Set<Role> r_u4 = new HashSet<>();
          r_u4.add(r1);

          User u5 = new User("Artur","Drukarski","arturdk@wp.pl","578109109","Chlebowa 14 Biale Blota","13-11-1992","arturrr3","poon13ac3&");
          Set<Role> r_u5 = new HashSet<>();
          r_u5.add(r1);

          User u6 = new User("Grzegorz","Matczak","grzemat33@interia.pl","581059105","Bydgoska 15 Poznań","12-10-1993","grzeg123","nonwq122;");
          Set<Role> r_u6 = new HashSet<>();
          r_u6.add(r1);

          User u7 = new User("Hubert","Tyczka","hubtyc@gmail.com","617598190","Dworcowa 15 Poznań","15-11-1996","hubm3233","124mino5*");
          Set<Role> r_u7 = new HashSet<>();
          r_u7.add(r1);

          User u8 = new User("Maciej","Galaz","macgal","581895105","Golebia 156 Poznan","05-06-1998","maciej3","1232mmkl4%");
          Set<Role> r_u8 = new HashSet<>();
          r_u8.add(r1);

          User u9 = new User("Blazej","Piotrowicz","blaz3@interia.pl","Jasna 15 Poznan","12-07-1982","blaz123","123mamp9{");
          Set<Role> r_u9 = new HashSet<>();
          r_u9.add(r1);

          User u10 = new User("Krzysztof","Nowak","krzynow2@o2.pl","Dluga 2 Poznan","09-01-1993","krzyfc","aminon12)");
          Set<Role> r_u10 = new HashSet<>();
          r_u10.add(r1);

          User u11 = new User("Tomasz","Pat","tomek123@gmail.com","Piekna 12 Warszawa","19-12-2000","tomm3","fnlasn122!");
          Set<Role> r_u11 = new HashSet<>();
          r_u11.add(r1);

          User u12 = new User("Bogdan","Lewandowski","boglew9@wp.pl","Miejska 12 Warszawa","12-09-1999","bogdan2","fasnon12^");
          Set<Role> r_u12 = new HashSet<>();
          r_u12.add(r1);

          User u13 = new User("Karolina","Bednarek","karolina.b@interia.pl","Krzywa 13 Warszawa","10-10-1990","karolina12","ksan13m;1");
          Set<Role> r_u13 = new HashSet<>();
          r_u13.add(r1);

          User u14 = new User("Szymon","Kimala","szymonn3fd@gmail.com","Twarogowa 13 Warszawa","12-11-1978","szmom31","asmdm12@");
          Set<Role> r_u14 = new HashSet<>();
          r_u14.add(r1);

          User u15 = new User("Karol","Fontanna","karolfontanna@gmail.com","Poznanska 13 Warszawa","11-12-1973","karolrr","anson133*"); 
          Set<Role> r_u15 = new HashSet<>();
          r_u15.add(r1);

          //salony
          Salon s1 = new Salon("Bydgoszcz","Fordonska 123");
          Salon s2 = new Salon("Poznan","Torunska 12");
          Salon s3 = new Salon("Warszawa","Waska 12");

          // samochody
          Car c1 = new Car("Passat","2012, czerwony","Volkswagen",1,1);
          Car c2 = new Car("Corolla","2016, srebrny","Toyota",1,1);
          Car c3 = new Car("Yaris","2010, niebieski","Toyota",1,1);
          Car c4 = new Car("Octavia","2013, czarny","Skoda",1,1);
          Car c5 = new Car("Duster","2016, zielony","Dacia",1,1);
          Car c6 = new Car("Fabia","2015, czerwony","Skoda",2,1);
          Car c7 = new Car("Sportage","2019, niebieski","Kia",2,1);
          Car c8 = new Car("Golf","2010, granatowy","Volkswagen",2,1);
          Car c9 = new Car("Corsa","2011, niebieski","Opel",2,1);
          Car c10 = new Car("Zafira","2016, czarny","Opel",2,1);
          Car c11 = new Car("X3","2020, czarny","BMW",3,1);
          Car c12 = new Car("C3","2018, zielony","Citroen",3,1);
          Car c13 = new Car("Leon","2011, srebrny","Seat",3,1);
          Car c14 = new Car("I20","2017, czarny","Hyundai",3,1);
          Car c15 = new Car("Q3","2020, czarny","Audi",3,1);
          

          
//
//    }
//}
