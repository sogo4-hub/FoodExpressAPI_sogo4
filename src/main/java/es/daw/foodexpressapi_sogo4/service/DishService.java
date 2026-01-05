package es.daw.foodexpressapi_sogo4.service;

import es.daw.foodexpressapi_sogo4.dto.DishDTO;
import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Dish;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import es.daw.foodexpressapi_sogo4.mapper.DishMapper;
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
    private final DishMapper dishMapper;
    public Page<DishDTO> getAllDishes(Pageable pageable) {
        Page<Dish> pageDishes = dishRepository.findAll(pageable);
        // 2. Mapeamos cada entidad Dish a DishDTO manteniendo la estructura de página
        return pageDishes.map(dishMapper::toDTO);
    }

//    private DishDTO toDTO(Dish dish){
//        return DishDTO.builder().
//                name(dish.getName()).
//                price(dish.getPrice()).
//                category(dish.getCategory()).
//                restaurantName(dish.getRestaurant().getName()).
//                build();
//    }

}
