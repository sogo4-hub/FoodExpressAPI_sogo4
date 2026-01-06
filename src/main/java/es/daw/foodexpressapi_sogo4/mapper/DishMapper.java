package es.daw.foodexpressapi_sogo4.mapper;

import es.daw.foodexpressapi_sogo4.dto.DishDTO;
import es.daw.foodexpressapi_sogo4.entity.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface DishMapper {
    Dish toEntity(DishDTO dishDTO);

    // Mapeamos los datos anidados del restaurante a campos planos del DTO
    @Mapping(source = "restaurant.name", target = "restaurantName")
    @Mapping(source = "restaurant.address", target = "restaurantAddress") // Nuevo
    @Mapping(source = "restaurant.phone", target = "restaurantPhone")     // Nuevo
    DishDTO toDTO(Dish dish);

    List<DishDTO> toDTOs(List<Dish> dishes);
    List<Dish> toEntities(List<DishDTO> dishesDTOs);
}
