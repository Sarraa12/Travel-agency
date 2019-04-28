package pl.sarraa12.travelagency.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sarraa12.travelagency.domain.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
