package es.daw.foodexpressapi_sogo4.service;

import es.daw.foodexpressapi_sogo4.dto.DishDTO;
import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Dish;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import es.daw.foodexpressapi_sogo4.repository.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
@Service
public class DishService {
    private final DishRepository dishRepository;
    public Page<DishDTO> getAllDishes(Pageable pageable) {
        // 1. Buscamos la página de entidades en la BD
        Page<Dish> pageDishes = dishRepository.findAll(pageable);

        // 2. Mapeamos cada entidad Dish a DishDTO manteniendo la estructura de página
        return pageDishes.map(this::toDTO);
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
