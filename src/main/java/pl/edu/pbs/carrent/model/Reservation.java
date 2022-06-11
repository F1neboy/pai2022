package pl.edu.pbs.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private ReservationState state;
    private Date expected_end_date;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user_reservation;

    @ManyToOne
    @JoinColumn(name="id_car")
    private Car car_reservation;

    @ManyToOne
    @JoinColumn(name="id_salon_start")
    private Salon salon_start;
    @ManyToOne
    @JoinColumn(name="id_salon_end")
    private Salon salon_end;

    @ManyToOne
    @JoinColumn(name="id_employee_start")
    private Employee employee_start;

    @ManyToOne
    @JoinColumn(name="id_employee_end")
    private Employee employee_end;



}
