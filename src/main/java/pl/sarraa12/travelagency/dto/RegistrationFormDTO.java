package pl.sarraa12.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormDTO {

    @NotNull(message = "{registration.username.notnull}")
    @Size(min = 3, max = 20)
    private String username;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
