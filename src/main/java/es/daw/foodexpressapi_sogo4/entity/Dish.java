package es.daw.foodexpressapi_sogo4.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name="dishes")
@Getter
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="price", nullable=false)
    private BigDecimal price;

    @Column(name="category", nullable=false)
    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Restaurant restaurant;




}
