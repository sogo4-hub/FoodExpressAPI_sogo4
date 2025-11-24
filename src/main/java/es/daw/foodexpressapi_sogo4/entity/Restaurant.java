package es.daw.foodexpressapi_sogo4.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name="restaurants")
@Getter
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

}
