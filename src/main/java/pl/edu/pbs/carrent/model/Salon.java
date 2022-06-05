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
@Table(name="salon")
public class Salon {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String address;

    @OneToMany(mappedBy = "salon_employee")
    private List<Employee> employees;

    @OneToMany(mappedBy = "salon")
    private List<Car> cars;

    @OneToMany(mappedBy = "salon_start")
    private List<Reservation> reservations_start;

    @OneToMany(mappedBy = "salon_end")
    private List<Reservation> reservations_end;

}
