package pl.sarraa12.travelagency.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "opinions")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Opinion extends AbstractEntity {

    private Integer tripOpinion;
    private String opinionDescription;
    @ManyToOne
    private Trip trip;
    @ManyToOne
    private User user;
}
