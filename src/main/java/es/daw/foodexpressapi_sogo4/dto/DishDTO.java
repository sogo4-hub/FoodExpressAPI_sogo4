package es.daw.foodexpressapi_sogo4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class DishDTO {
    private String name;
    private BigDecimal price;
    private String category;
    private String restaurantName;
}
