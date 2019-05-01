package pl.sarraa12.travelagency.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Trip extends AbstractEntity {

    @Column(nullable = false)
    private String destinationCity;
    @Column(nullable = false)
    private String destinationCountry;
    @Column(nullable = false)
    private LocalDate departureDate;
    @Column(nullable = false)
    private LocalDate returnDate;
    @Column(nullable = false)
    private Integer placeLimit;
    @Column(nullable = false)
    private LocalDate bookingDeadline;
    @Column(nullable = false)
    private BigDecimal price;
    // user
    @ManyToMany(mappedBy = "trips")
    private List<User> users = new ArrayList<>();
    //hotel
    @ManyToOne
    private Hotel hotel;
    // tripOpinion
    @OneToMany(mappedBy = "trip")
    private List<Opinion> opinions = new ArrayList<>();

}