package pl.sarraa12.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpinionFormDTO {

    @NotNull
    private Integer tripOpinion;
    @NotBlank
    private String opinionDescription;
}
