package pl.sarraa12.travelagency.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "opinions")
public class Opinion extends AbstractEntity{

    private Integer hotelOpinion;
    private String hotelOpinionDescription;
    private Integer tripOpinion;
    private String tripOpinionDescription;

}
