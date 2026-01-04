package es.daw.foodexpressapi_sogo4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="restaurants")
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column
    private String address;
    @Column(length = 20)
    private String phone;

    // En es.daw.foodexpressapi.entity.Restaurant
    @OneToMany(mappedBy = "restaurant") // "restaurant" es el nombre del atributo en la clase Order
    private List<Order> orders = new ArrayList<>();

}
