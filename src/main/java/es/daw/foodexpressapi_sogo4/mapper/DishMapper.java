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
    // Indicamos a MapStruct de dónde sacar el nombre del restaurante
    @Mapping(source = "restaurant.name", target = "restaurantName")
    DishDTO toDTO(Dish dish);
    List<DishDTO> toDTOs(List<Dish> dishes);
    List<Dish> toEntities(List<DishDTO> dishesDTOs);

}
