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
    private String description;
    private String brand;
    @ManyToOne
    @JoinColumn(name="id_salon")
    private Salon salon;
    private Boolean available;

    @OneToMany(mappedBy = "car_reservation")
    private List<Reservation> reservations;
}
