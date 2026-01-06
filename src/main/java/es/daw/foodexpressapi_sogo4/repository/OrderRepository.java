package es.daw.foodexpressapi_sogo4.repository;

import es.daw.foodexpressapi_sogo4.entity.Order;
import es.daw.foodexpressapi_sogo4.enumerado.OrderStatus;
import org.springframework.data.domain.Sort; //
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Importante para usar @Param si fuera necesario, aunque aquí es posicional o por nombre

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Se añade el parámetro Sort al final del método
    // CAMBIO CLAVE: Añadimos "JOIN o.user u" y "JOIN o.restaurant r"
    // Esto permite acceder a las tablas para ordenar por sus campos
    @Query("SELECT o FROM Order o " +
            "JOIN o.user u " +
            "JOIN o.restaurant r " +
            "WHERE " +
            "(:status IS NULL OR o.status = :status) AND " +
            "(:userId IS NULL OR u.id = :userId) AND " +      // Optimizamos usando el alias 'u'
            "(:restaurantId IS NULL OR r.id = :restaurantId)") // Optimizamos usando el alias 'r'
    List<Order> findByFilters(OrderStatus status, Long userId, Long restaurantId, Sort sort);
}
