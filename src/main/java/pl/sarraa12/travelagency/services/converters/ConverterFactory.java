package pl.sarraa12.travelagency.services.converters;

import pl.sarraa12.travelagency.domain.model.Hotel;
import pl.sarraa12.travelagency.domain.model.Trip;
import pl.sarraa12.travelagency.domain.model.User;
import pl.sarraa12.travelagency.dto.HotelFormDTO;
import pl.sarraa12.travelagency.dto.TripFormDTO;
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
    public static Trip convertTrip(TripFormDTO tripFormDTO){
        Trip trip = new Trip();
        trip.setDestinationCity(tripFormDTO.getDestinationCity());
        trip.setBookingDeadline(tripFormDTO.getBookingDeadline());
        trip.setDepartureDate(tripFormDTO.getDepartureDate());
        trip.setDestinationCountry(tripFormDTO.getDestinationCountry());
        trip.setPlaceLimit(tripFormDTO.getPlaceLimit());
        trip.setPrice(tripFormDTO.getPrice());
        trip.setReturnDate(tripFormDTO.getReturnDate());
        return trip;
    }

    public static TripFormDTO convertTripForm(Trip trip){
        TripFormDTO formDTO = new TripFormDTO();
        formDTO.setDestinationCity(trip.getDestinationCity());
        formDTO.setBookingDeadline(trip.getBookingDeadline());
        formDTO.setDepartureDate(trip.getDepartureDate());
        formDTO.setDestinationCountry(trip.getDestinationCountry());
        formDTO.setPlaceLimit(trip.getPlaceLimit());
        formDTO.setPrice(trip.getPrice());
        formDTO.setReturnDate(trip.getReturnDate());
        return formDTO;
    }

    public static Hotel convertHotel(HotelFormDTO hotelFormDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelFormDTO.getName());
        hotel.setLocationCity(hotelFormDTO.getLocationCity());
        hotel.setLocationCountry(hotelFormDTO.getLocationCountry());
        hotel.setNumberOfRooms(hotelFormDTO.getNumberOfRooms());
        return hotel;
    }

    public static HotelFormDTO convertHotelForm(Hotel hotel) {
        HotelFormDTO hotelFormDTO = new HotelFormDTO();
        hotelFormDTO.setName(hotel.getName());
        hotelFormDTO.setLocationCity(hotel.getLocationCity());
        hotelFormDTO.setLocationCountry(hotel.getLocationCountry());
        hotelFormDTO.setNumberOfRooms(hotel.getNumberOfRooms());
        return hotelFormDTO;
    }
}
