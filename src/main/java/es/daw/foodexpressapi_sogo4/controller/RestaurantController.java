package es.daw.foodexpressapi_sogo4.controller;

import es.daw.foodexpressapi_sogo4.dto.RestaurantDTO;
import es.daw.foodexpressapi_sogo4.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> findAll() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }
}
