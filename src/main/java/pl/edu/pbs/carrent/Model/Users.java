package pl.edu.pbs.carrent.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date Birthdate;

    @OneToOne
    @JoinColumn(name="id_auth")
    private Auth auth_users;

    @OneToMany(mappedBy = "users_reservation")
    private List<Reservation> reservation;

}
