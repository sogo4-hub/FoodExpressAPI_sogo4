package es.daw.foodexpressapi_sogo4.mapper;

import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    Restaurant toEntity(RestaurantDTO restaurantDTO);
    RestaurantDTO toDTO(Restaurant restaurant);
    List<RestaurantDTO> toDTOs(List<Restaurant> restaurants);
    List<Restaurant> toEntities(List<RestaurantDTO> restaurantDTOs);
}
