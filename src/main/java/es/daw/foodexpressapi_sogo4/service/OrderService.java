package es.daw.foodexpressapi_sogo4.service;



import es.daw.foodexpressapi_sogo4.dto.OrderResponseDTO;
import es.daw.foodexpressapi_sogo4.entity.Order;
import es.daw.foodexpressapi_sogo4.enumerado.OrderStatus;
import es.daw.foodexpressapi_sogo4.exceptions.InvalidStatusException;
import es.daw.foodexpressapi_sogo4.exceptions.RestaurantNotFoundException;
import es.daw.foodexpressapi_sogo4.exceptions.UserNotFoundException;
import es.daw.foodexpressapi_sogo4.repository.OrderRepository;
import es.daw.foodexpressapi_sogo4.repository.UserRepository;
import es.daw.foodexpressapi_sogo4.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public List<OrderResponseDTO> searchOrders(String statusStr, Long userId, Long restaurantId) {
        OrderStatus status = null;

        // 1. Validación de Status: Solo validamos si NO es nulo y NO está vacío
        if (statusStr != null && !statusStr.trim().isEmpty()) { // <--- CAMBIO AQUÍ
            try {
                status = OrderStatus.valueOf(statusStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new InvalidStatusException("Status '" + statusStr + "' is not valid");
            }
        }

        // 2. Validación de existencia de Usuario (Lanza 404)
        if (userId != null && !userRepository.existsById(userId)) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }

        // 3. Validación de existencia de Restaurante (Lanza 404)
        if (restaurantId != null && !restaurantRepository.existsById(restaurantId)) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + restaurantId);
        }

        // 4. Búsqueda en repositorio y mapeo a DTO
        return orderRepository.findByFilters(status, userId, restaurantId)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private OrderResponseDTO toResponseDTO(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                .status(order.getStatus().name())
                .userId(order.getUser().getId())
                .username(order.getUser().getUsername())
                .restaurantId(order.getRestaurant().getId())
                .restaurantName(order.getRestaurant().getName())
                .build();
    }
}
