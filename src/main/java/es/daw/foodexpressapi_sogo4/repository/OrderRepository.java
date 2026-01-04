package es.daw.foodexpressapi_sogo4.repository;

import es.daw.foodexpressapi_sogo4.entity.Order;
import es.daw.foodexpressapi_sogo4.enumerado.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE " +
            "(:status IS NULL OR o.status = :status) AND " +
            "(:userId IS NULL OR o.user.id = :userId) AND " +
            "(:restaurantId IS NULL OR o.restaurant.id = :restaurantId)")
    List<Order> findByFilters(OrderStatus status, Long userId, Long restaurantId);
}
