package pl.edu.pbs.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;


    @ManyToOne
    @JoinColumn(name="idSalon")
    private Salon salonEmployee;


    @OneToMany(mappedBy = "employeeStart")
    private List<Reservation> reservationsStart;

    @OneToMany(mappedBy = "employeeEnd")
    private List<Reservation> reservationsEnd;
}
