package pl.sarraa12.travelagency.services;

import pl.sarraa12.travelagency.dto.RegistrationFormDTO;

public interface UserService {
    boolean isUsernameFree(String username);
    void registerUser(RegistrationFormDTO registrationForm);
}
