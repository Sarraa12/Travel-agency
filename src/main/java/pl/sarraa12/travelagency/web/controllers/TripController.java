package pl.sarraa12.travelagency.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sarraa12.travelagency.domain.model.Trip;
import pl.sarraa12.travelagency.domain.model.User;
import pl.sarraa12.travelagency.domain.repositories.HotelRepository;
import pl.sarraa12.travelagency.domain.repositories.TripRepository;
import pl.sarraa12.travelagency.domain.repositories.UserRepository;
import pl.sarraa12.travelagency.dto.TripFormDTO;
import pl.sarraa12.travelagency.dto.SearchTripDTO;
import pl.sarraa12.travelagency.services.converters.ConverterFactory;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class TripController {

    private TripRepository tripRepository;
    private UserRepository userRepository;
    private HotelRepository hotelRepository;

    public TripController(TripRepository tripRepository, UserRepository userRepository, HotelRepository hotelRepository) {

        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    // find trip
    @GetMapping("/find")
    public String prepareSearchPage(Model model) {
        model.addAttribute("searchForm", new SearchTripDTO());
        return "searchForm";
    }

    @PostMapping("/find")
    public String search(@Valid @ModelAttribute("searchForm") SearchTripDTO tripDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "searchForm";
        }
        model.addAttribute("tripsList", tripRepository.findByDestinationCityAndDestinationCountryAndDepartureDateBetween(
                tripDTO.getDestinationCity(), tripDTO.getDestinationCountry(), tripDTO.getDepartureDateStart(), tripDTO.getDepartureDateEnd()));
        return "showAllTrips";
    }

    // all trips
    @GetMapping("/showAll")
    public String showList(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("tripsList", tripRepository.findAll());
        model.addAttribute("userTrips", user.getTrips());
        return "showAllTrips";
    }


    //add trip
    @PostMapping("/addTrip")
    public String saveTrip(@Valid @ModelAttribute("trip") TripFormDTO tripFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "tripForm";
        }
        if (tripFormDTO.getDepartureDate().isAfter(tripFormDTO.getReturnDate())) {
            result.rejectValue("departureDate", null, "Date of departure must be before date of return");
            return "tripForm";
        }
        if (tripFormDTO.getBookingDeadline().isAfter(tripFormDTO.getDepartureDate())) {
            result.rejectValue("bookingDeadline", null, "Booking deadline must be before date of departure");
            return "tripForm";
        }
        tripRepository.save(ConverterFactory.convertTrip(tripFormDTO));

        return "redirect:/showAll";
    }

    @GetMapping("/addTrip")
    public String saveArticle(Model model) {
        model.addAttribute("trip", new TripFormDTO());
        model.addAttribute("hotels", hotelRepository.findAll());
        return "tripForm";

    }

    //delete trip
    @GetMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripRepository.deleteById(id);
        return "redirect:/showAll";

    }

    //update trip
    @PostMapping("/update/{id}")
    public String updateTrip(@Valid @ModelAttribute("trip") TripFormDTO tripFormDTO, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "tripForm";
        }
        if (tripFormDTO.getDepartureDate().isAfter(tripFormDTO.getReturnDate())) {
            result.rejectValue("departureDate", null, "Date of departure must be before date of return");
            return "tripForm";
        }
        if (tripFormDTO.getBookingDeadline().isAfter(tripFormDTO.getDepartureDate())) {
            result.rejectValue("bookingDeadline", null, "Booking deadline must be before date of departure");
            return "tripForm";
        }
        Trip trip = ConverterFactory.convertTrip(tripFormDTO);
        trip.setId(id);
        tripRepository.save(trip);

        return "redirect:/showAll";
    }

    @GetMapping("/update/{id}")
    public String updateTrip(@PathVariable Long id, Model model) {
        model.addAttribute("trip", ConverterFactory.convertTripForm(tripRepository.getOne(id)));
        return "tripForm";

    }
}