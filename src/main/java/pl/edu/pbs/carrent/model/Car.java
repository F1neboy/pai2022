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
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private Long id_salon;
    private Boolean available;

    @OneToMany(mappedBy = "cars_reservation")
    private List<Reservation> reservations;
}
