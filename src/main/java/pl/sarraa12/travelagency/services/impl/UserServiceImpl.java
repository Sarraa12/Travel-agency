package pl.sarraa12.travelagency.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sarraa12.travelagency.domain.model.User;
import pl.sarraa12.travelagency.domain.repositories.UserRepository;
import pl.sarraa12.travelagency.dto.RegistrationFormDTO;
import pl.sarraa12.travelagency.services.UserService;
import pl.sarraa12.travelagency.services.converters.ConverterFactory;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean isUsernameFree(String username) {
        return userRepository.isUsernameFree(username);
    }

    @Override
    public void registerUser(RegistrationFormDTO registrationForm) {
        User userToRegister = ConverterFactory.converterUser(registrationForm);
        userToRegister.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        userRepository.save(userToRegister);
    }
}
