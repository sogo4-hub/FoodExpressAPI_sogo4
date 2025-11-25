package es.daw.foodexpressapi_sogo4.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class RestaurantDTO {

    private String name;
    private String address;
    private String phone;
}
