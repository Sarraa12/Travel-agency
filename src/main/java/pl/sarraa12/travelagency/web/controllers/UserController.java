package pl.sarraa12.travelagency.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sarraa12.travelagency.domain.model.User;
import pl.sarraa12.travelagency.domain.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/showAll")
    public String showList(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if(user!=null){
            model.addAttribute("userTrips", user.getTrips());
        }
        return "showAllUserTrips";
    }
}
