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

    @OneToMany(mappedBy = "salonEmployee")
    private List<Employee> employees;

    @OneToMany(mappedBy = "salon")
    private List<Car> cars;

    @OneToMany(mappedBy = "salonStart")
    private List<Reservation> reservationsStart;

    @OneToMany(mappedBy = "salonEnd")
    private List<Reservation> reservationsEnd;

}
