package es.daw.foodexpressapi_sogo4.repository;

import es.daw.foodexpressapi_sogo4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findAllBy();
}
