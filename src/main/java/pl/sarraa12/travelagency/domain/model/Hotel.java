package pl.sarraa12.travelagency.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String locationCity;
    @Column(nullable = false)
    private String locationCountry;
    @Column(nullable = false)
    private Integer numberOfRooms;
    @Column(nullable = false)
    private boolean food;
    //    opinie
//    @ManyToMany(mappedBy = "opinions")
//    private List<Opinion> opinions = new ArrayList<>();
//    @ManyToMany(mappedBy = "trips")
//    private List<Trip> trips = new ArrayList<>();
}

//- nazwa
//        - lokalizacja
//        - ilu osobowe pokoje
//        - opinie
