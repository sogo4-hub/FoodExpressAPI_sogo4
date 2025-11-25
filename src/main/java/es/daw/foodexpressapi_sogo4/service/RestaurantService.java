package es.daw.foodexpressapi_sogo4.service;

import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import es.daw.foodexpressapi_sogo4.mapper.RestaurantMapper;
import es.daw.foodexpressapi_sogo4.repository.RestaurantRepository;
import java.util.Optional;
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
    private final RestaurantMapper restaurantMapper;
    public List<RestaurantDTO> getAllRestaurants() {
         List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurantMapper.toDTOs(restaurants);
    }

    public Optional<RestaurantDTO> createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.toEntity(restaurantDTO);
        Restaurant restaurantSaved = restaurantRepository.save(restaurant);
        return Optional.of(restaurantMapper.toDTO(restaurantSaved));
    }

//    private RestaurantDTO toDTO(Restaurant restaurant){
//        return new RestaurantDTO(restaurant.getName(), restaurant.getAddress(), restaurant.getPhone());
//    }

//  private RestaurantDTO toDTO(Restaurant restaurant){
//    return RestaurantDTO.builder().
//            name(restaurant.getName()).
//            address(restaurant.getAddress()).
//            phone(restaurant.getPhone()).
//            build();
//}

    //Pendiente: METER MAPSTRUCT!!!!





}
