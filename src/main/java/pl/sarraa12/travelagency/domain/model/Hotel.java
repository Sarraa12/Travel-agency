package pl.sarraa12.travelagency.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Hotel extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String locationCity;
    @Column(nullable = false)
    private String locationCountry;
    @Column(nullable = false)
    private Integer numberOfRooms;

}

