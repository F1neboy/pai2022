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
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;


    @ManyToOne
    @JoinColumn(name="id_salon")
    private Salons salons_employee;


    @OneToMany(mappedBy = "employee_start")
    private List<Reservation> reservations_start;

    @OneToMany(mappedBy = "employee_end")
    private List<Reservation> reservations_end;
}
