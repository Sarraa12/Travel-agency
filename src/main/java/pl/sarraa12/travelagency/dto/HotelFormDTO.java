package pl.sarraa12.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelFormDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String locationCity;
    @NotBlank
    private String locationCountry;
    @NotNull
    private Integer numberOfRooms;
}
