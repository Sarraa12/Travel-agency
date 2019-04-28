package pl.sarraa12.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTripDTO {

    @NotBlank
    private String destinationCity;
    @NotBlank
    private String destinationCountry;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDateEnd;

}