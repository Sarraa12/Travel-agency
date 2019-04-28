package pl.sarraa12.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {

    @NotBlank
    private String destinationCity;
    @NotBlank
    private String destinationCountry;
    private LocalDate departureDate;
    private LocalDate returnDate;

}