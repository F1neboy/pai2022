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
@Table(name="Cars")
public class Cars {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private Long id_salon;
    private Boolean available;

    @OneToMany(mappedBy = "cars_reservation")
    private List<Reservation> reservations;
}
