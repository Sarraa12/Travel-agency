package pl.sarraa12.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTripDTO {

    private Long id;
    private String destinationCity;
    private String destinationCountry;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future @NotNull
    private LocalDate departureDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future @NotNull
    private LocalDate returnDate;
    private Integer placeLimit;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future @NotNull
    private LocalDate bookingDeadline;
    private BigDecimal price;

}
