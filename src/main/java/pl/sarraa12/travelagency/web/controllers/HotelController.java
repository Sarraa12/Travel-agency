package pl.sarraa12.travelagency.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sarraa12.travelagency.domain.model.Hotel;
import pl.sarraa12.travelagency.domain.repositories.HotelRepository;
import pl.sarraa12.travelagency.dto.HotelFormDTO;
import pl.sarraa12.travelagency.services.converters.ConverterFactory;

import javax.validation.Valid;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // all hotels
    @GetMapping("/showAll")
    public String showList(Model model) {
        model.addAttribute("hotelsList", hotelRepository.findAll());

        return "showAllHotels";
    }
    // add hotel
    @PostMapping("/add")
    public String saveHotel(@Valid @ModelAttribute("hotel") HotelFormDTO hotelFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "tripForm";
        }
        hotelRepository.save(ConverterFactory.convertHotel(hotelFormDTO));

        return "redirect:/hotel/showAll";
    }

    @GetMapping("/add")
    public String saveHotel(Model model) {
        model.addAttribute("hotel", new HotelFormDTO());
        return "hotelForm";
    }

    //delete hotel
    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelRepository.deleteById(id);
        return "redirect:/hotel/showAll";
    }
    //update hotel
    @PostMapping("/update/{id}")
    public String updateHotel(@Valid @ModelAttribute("hotel") HotelFormDTO hotelFormDTO, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "hotelForm";
        }
        Hotel hotel = ConverterFactory.convertHotel(hotelFormDTO);
        hotel.setId(id);
        hotelRepository.save(hotel);

        return "redirect:/hotel/showAll";
    }

    @GetMapping("/update/{id}")
    public String updateHotel(@PathVariable Long id, Model model) {
        model.addAttribute("hotel", ConverterFactory.convertHotelForm(hotelRepository.getOne(id)));
        return "hotelForm";
    }
}
