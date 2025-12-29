package es.daw.foodexpressapi_sogo4.service;

import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import es.daw.foodexpressapi_sogo4.mapper.RestaurantMapper;
import es.daw.foodexpressapi_sogo4.repository.RestaurantRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    public List<RestaurantDTO> getAllRestaurants() {
         List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurantMapper.toDTOs(restaurants);
    }

    public Optional<RestaurantDTO> create(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.toEntity(restaurantDTO);
        Restaurant restaurantSaved = restaurantRepository.save(restaurant);
        return Optional.of(restaurantMapper.toDTO(restaurantSaved));
    }

    /**
     * Sin gestionar excepcion "NoExisteElRestaurante"
     * @param id
     * @return
     */
    public boolean delete(Long id) {
        if (!restaurantRepository.existsById(id)) {
            return false;
        }
        restaurantRepository.deleteById(id);
        return true;
    }

    public RestaurantDTO update(Long id, RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(id).
                orElseThrow(() -> new RuntimeException("No existe el restaurante con id: " + id));
//            restaurant.setId(id);
//            restaurant.setId(restaurantDTO.getId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setPhone(restaurantDTO.getPhone());
        Restaurant updated = restaurantRepository.save(restaurant);
        return restaurantMapper.toDTO(updated);
    }

    public Optional<RestaurantDTO> findById(Long id) {
        return restaurantRepository.findById(id)
                .map(restaurantMapper::toDTO);
    }

}
