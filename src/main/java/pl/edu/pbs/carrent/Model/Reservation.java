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
@Table(name="Reservation")
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private Date startDate;
    private Date endDate;
    private ReservationState state;
    private Date expected_end_date;

    @ManyToOne
    @JoinColumn(name="id_user")
    private Users users_reservation;

    @ManyToOne
    @JoinColumn(name="id_car")
    private Cars cars_reservation;

    @ManyToOne
    @JoinColumn(name="id_salon_start")
    private Salons salons_start;
    @ManyToOne
    @JoinColumn(name="id_salon_end")
    private Salons salons_end;

    @ManyToOne
    @JoinColumn(name="id_employee_start")
    private Employee employee_start;

    @ManyToOne
    @JoinColumn(name="id_employee_end")
    private Employee employee_end;



}
