package pl.sarraa12.travelagency.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sarraa12.travelagency.domain.model.Trip;
import pl.sarraa12.travelagency.domain.repositories.TripRepository;
import pl.sarraa12.travelagency.dto.TripDTO;
import pl.sarraa12.travelagency.services.TripService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TripController {

    private TripService tripService;
    private TripRepository tripRepository;

    public TripController(TripService tripService, TripRepository tripRepository) {
        this.tripService = tripService;
        this.tripRepository = tripRepository;
    }
    // find trip
    @GetMapping("/find")
    public String prepareSearchPage(Model model) {
        model.addAttribute("searchForm", new TripDTO());
        return "searchForm";
    }

    private List<Trip> showSelectedTrips(@ModelAttribute("destinationCity") String destinationCity,
                                         @ModelAttribute("destinationCountry") String destinationCountry) {
        return tripRepository.findByDestinationCityAndDestinationCountry(destinationCity, destinationCountry);
    }

    @PostMapping("/find")
    public String search(@Valid @ModelAttribute("searchForm") TripDTO tripDTO, BindingResult result, Model model,
                         @ModelAttribute("destinationCity") String destinationCity,
                         @ModelAttribute("destinationCountry") String destinationCountry) {
        if (result.hasErrors()) {
            return "searchForm";
        }
        model.addAttribute("tripsList", showSelectedTrips(destinationCity, destinationCountry));
        return "showAllTrips";
    }


    // all trips
    private List<Trip> showTripList() {
        return tripRepository.findAll();
    }

    @GetMapping("/showAll")
    public String showList(Model model) {
        model.addAttribute("tripsList", showTripList());
        return "showAllTrips";
    }
    //add trip
    @PostMapping("/addTrip")
    public String saveArticle(@ModelAttribute Trip trip, BindingResult result) {
        if (result.hasErrors()) {
            return "tripForm";
        }
        tripRepository.save(trip);

        return "home";
    }

    @GetMapping("/addTrip")
    public String saveArticle(Model model) {
        model.addAttribute("trip", new Trip());
        return "tripForm";

    }
//    @GetMapping("/{id}/edit")
//    public String editUser(Model model, @PathVariable long id) {
//
//        model.addAttribute("user", mainService.getUserById(id));
//
//        return "users/add";
//    }
//
//    @PostMapping("/{id}/edit")
//    @ResponseBody
//    public String processEditUser(@ModelAttribute User user) {
//        mainService.saveUser(user);
//        return "Użytkownik został wyedytowany";
//    }
//
//    @GetMapping("/{id}/delete")
//    @ResponseBody
//    public String deleteUser(@PathVariable long id) {
//        mainService.deleteUser(id);
//        return "Użytkownik został usunięty";
//    }

}
//    public List<Author> myFindByEmailStartsWith(@RequestParam("letters") String letters){
//        return authorRepository.myFindByEmailStartsWith(letters);
//    }