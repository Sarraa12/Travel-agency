package pl.sarraa12.travelagency.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sarraa12.travelagency.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT CASE WHEN count(u) = 0 THEN true ELSE false END FROM User u WHERE u.username = ?1")
    boolean isUsernameFree(String username);
}
