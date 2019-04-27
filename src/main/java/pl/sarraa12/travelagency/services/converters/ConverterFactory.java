package pl.sarraa12.travelagency.services.converters;

import pl.sarraa12.travelagency.domain.model.User;
import pl.sarraa12.travelagency.dto.RegistrationFormDTO;

public class ConverterFactory {
    public static User converterUser(RegistrationFormDTO registrationForm) {
        User user = new User();
        user.setFirstName(registrationForm.getFirstName());
        user.setLastName(registrationForm.getLastName());
        user.setUsername(registrationForm.getUsername());
        user.setPassword(registrationForm.getPassword());
        return user;
    }
//    public
}
