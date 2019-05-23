package pl.sarraa12.travelagency.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sarraa12.travelagency.domain.model.Trip;
import pl.sarraa12.travelagency.domain.model.User;
import pl.sarraa12.travelagency.domain.repositories.TripRepository;
import pl.sarraa12.travelagency.domain.repositories.UserRepository;
import pl.sarraa12.travelagency.services.converters.ConverterFactory;

import java.security.Principal;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private UserRepository userRepository;
    private TripRepository tripRepository;

    public BookingController(UserRepository userRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
    }

    @GetMapping("/{tripId}")
    public String prepareBookingTripPage(@PathVariable Long tripId, Principal principal, Model model) {
        User user = userRepository.findByUsername(principal.getName());
        Trip trip = tripRepository.getOne(tripId);
        user.getTrips().add(trip);
        userRepository.save(user);
        trip.setPlaceLimit(trip.getPlaceLimit()-1);
        tripRepository.save(trip);
        return "redirect:/trips/showAll";
    }
}
