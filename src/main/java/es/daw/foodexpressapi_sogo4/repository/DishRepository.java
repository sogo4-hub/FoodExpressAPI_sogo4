package es.daw.foodexpressapi_sogo4.repository;

import es.daw.foodexpressapi_sogo4.dto.DishDTO;
import es.daw.foodexpressapi_sogo4.entity.Dish;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAll();
    List<Dish> findByRestaurantId(Long restauranteId);

}
