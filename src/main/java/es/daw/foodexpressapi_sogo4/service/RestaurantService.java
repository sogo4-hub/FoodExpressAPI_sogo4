package es.daw.foodexpressapi_sogo4.service;

import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import es.daw.foodexpressapi_sogo4.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    public List<RestaurantDTO> getAllRestaurants() {
         List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants
                .stream()
                .map(this::toDTO)
                .toList();
    }

//    private RestaurantDTO toDTO(Restaurant restaurant){
//        return new RestaurantDTO(restaurant.getName(), restaurant.getAddress(), restaurant.getPhone());
//    }

  private RestaurantDTO toDTO(Restaurant restaurant){
    return RestaurantDTO.builder().
            name(restaurant.getName()).
            address(restaurant.getAddress()).
            phone(restaurant.getPhone()).
            build();
}

    //Pendiente: METER MAPSTRUCT!!!!





}
