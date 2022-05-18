package pl.edu.pbs.carrent.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Salons")
public class Salons {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String address;

    @OneToMany(mappedBy = "salons_employee")
    private List<Employee> employee;

    @OneToMany(mappedBy = "salons_start")
    private List<Reservation> reservations_start;

    @OneToMany(mappedBy = "salons_end")
    private List<Reservation> reservations_end;

}
