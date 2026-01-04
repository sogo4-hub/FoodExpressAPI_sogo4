package es.daw.foodexpressapi_sogo4.entity;

import es.daw.foodexpressapi_sogo4.enumerado.OrderStatus;
import jakarta.persistence.*;
import lombok.Data; // Importa esto
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders") // Coincide con CREATE TABLE orders
@Data                // <--- ESTA ES LA CLAVE: genera getters, setters, toString, etc.
@NoArgsConstructor   // Genera el constructor vacío requerido por JPA
@AllArgsConstructor  // Genera el constructor con todos los campos
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    // IMPORTANTE: Mapeo del VARCHAR(30) al Enum
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Relación con OrderDetails...
}
