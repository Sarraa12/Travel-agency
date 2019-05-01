package pl.sarraa12.travelagency.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sarraa12.travelagency.domain.model.Opinion;
import pl.sarraa12.travelagency.domain.model.Trip;
import pl.sarraa12.travelagency.domain.model.User;
import pl.sarraa12.travelagency.domain.repositories.OpinionRepository;
import pl.sarraa12.travelagency.domain.repositories.TripRepository;
import pl.sarraa12.travelagency.domain.repositories.UserRepository;
import pl.sarraa12.travelagency.dto.OpinionFormDTO;
import pl.sarraa12.travelagency.services.converters.ConverterFactory;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/opinion")
public class OpinionController{

    private OpinionRepository opinionRepository;
    private TripRepository tripRepository;
    private UserRepository userRepository;

    public OpinionController(OpinionRepository opinionRepository, TripRepository tripRepository, UserRepository userRepository) {
        this.opinionRepository = opinionRepository;
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }


    @PostMapping("/add/{id}")
    public String addOpinion(@PathVariable Long id, @Valid @ModelAttribute("opinion") OpinionFormDTO opinionFormDTO,
                             BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "opinionForm";
        }
        Opinion opinion = ConverterFactory.convertOpinion(opinionFormDTO);
        Trip trip = tripRepository.getOne(id);
        User user = userRepository.findByUsername(principal.getName());
        opinion.setTrip(trip);
        opinion.setUser(user);
        opinionRepository.save(opinion);

        return "redirect:/user/showAll";
    }

    @GetMapping("/add/{id}")
    public String addOpinion(@PathVariable Long id, Model model) {
        model.addAttribute("opinion", new OpinionFormDTO());
        return "opinionForm";
    }


}
