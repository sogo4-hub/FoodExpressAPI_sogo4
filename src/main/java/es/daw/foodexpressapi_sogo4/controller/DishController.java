package es.daw.foodexpressapi_sogo4.controller;

import es.daw.foodexpressapi_sogo4.dto.DishDTO;
import es.daw.foodexpressapi_sogo4.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/dish")
@AllArgsConstructor
public class DishController {

    private final DishService dishService;
    @GetMapping
    public ResponseEntity<List<DishDTO>> findAll() {
        return ResponseEntity.ok(dishService.getAllDishes());
    }

}
