package es.daw.foodexpressapi_sogo4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Builder
public class RestaurantDTO {

    private String name;
    private String address;
    private String phone;
}
