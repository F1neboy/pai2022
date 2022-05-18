package pl.edu.pbs.carrent.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Auth")
public class Auth {
    @Id
    @GeneratedValue
    private Long Id;
    private String Login;
    private String Password;
    private String Role;

    @OneToOne(mappedBy = "auth_users")
    private Users users;

    @OneToOne(mappedBy = "auth_employee")
    private Employee employee;
}
