package es.daw.foodexpressapi_sogo4.service;

import es.daw.foodexpressapi_sogo4.dto.DishDTO;
import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Dish;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import es.daw.foodexpressapi_sogo4.repository.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DishService {
    private final DishRepository dishRepository;
    public List<DishDTO> getAllDishes() {
        List<Dish> dishes= dishRepository.findAll();
        return dishes.stream().map(this::toDTO).toList();
    }

    private DishDTO toDTO(Dish dish){
        return DishDTO.builder().
                name(dish.getName()).
                price(dish.getPrice()).
                category(dish.getCategory()).
                restaurantName(dish.getRestaurant().getName()).
                build();
    }

}
