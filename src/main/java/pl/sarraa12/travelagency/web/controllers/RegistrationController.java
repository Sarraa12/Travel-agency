package pl.sarraa12.travelagency.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sarraa12.travelagency.dto.RegistrationFormDTO;
import pl.sarraa12.travelagency.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model){
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping
    public String procesRegistrationPage(@Valid @ModelAttribute("registrationForm") RegistrationFormDTO registrationForm,
                                         BindingResult result){
        if(result.hasErrors()){
            return "registration";
        }
        boolean usernameFree = userService.isUsernameFree(registrationForm.getUsername());
        if(!usernameFree){
            result.rejectValue("username", null, "Username is already taken");
            return "registration";
        }
        userService.registerUser(registrationForm);
        return "redirect:/";

    }

}
