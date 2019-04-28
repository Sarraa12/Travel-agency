package pl.sarraa12.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sarraa12.travelagency.domain.model.Hotel;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripFormDTO {

    @NotBlank
    private String destinationCity;
    @NotBlank
    private String destinationCountry;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future @NotNull
    private LocalDate departureDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future @NotNull
    private LocalDate returnDate;
    @NotNull
    private Integer placeLimit;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future @NotNull
    private LocalDate bookingDeadline;
    @NotNull
    private BigDecimal price;
    private Hotel hotel;

}
