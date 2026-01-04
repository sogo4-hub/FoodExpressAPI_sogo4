package es.daw.foodexpressapi_sogo4.dto;


import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class OrderResponseDTO {
    private Long id;
    private String orderDate; // Formateado como String para facilitar la lectura
    private String status;
    private Long userId;
    private String username;
    private Long restaurantId;
    private String restaurantName;
}
