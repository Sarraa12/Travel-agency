package pl.sarraa12.travelagency.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sarraa12.travelagency.domain.model.Trip;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByDestinationCityAndDestinationCountry(String destinationCity, String destinationCountry);

}
