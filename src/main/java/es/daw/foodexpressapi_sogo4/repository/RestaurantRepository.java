package es.daw.foodexpressapi_sogo4.repository;

import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    public List<Restaurant> findAll();
    public Optional<Restaurant> findById(Long id);
    public Restaurant save(Restaurant restaurant);
    public void delete(Restaurant restaurant);
}
