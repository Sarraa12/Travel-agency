package pl.sarraa12.travelagency.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sarraa12.travelagency.domain.model.Trip;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByDestinationCityAndDestinationCountryAndDepartureDateBetween(
            String destinationCity, String destinationCountry, LocalDate departureDateStart, LocalDate departureDateEnd);

}
