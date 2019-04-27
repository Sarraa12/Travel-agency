package pl.sarraa12.travelagency.services;

import org.springframework.data.jpa.repository.Query;
import pl.sarraa12.travelagency.domain.model.Trip;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface TripService {


}

//    @Query("SELECT a from Author a where a.email like ?1%")
//    List<Author> myFindByEmailStartsWith(String letters);
//List<Person> findByLastNameAndFirstNameAllIgnoreCase(String lastName,
//                                                     String firstName);