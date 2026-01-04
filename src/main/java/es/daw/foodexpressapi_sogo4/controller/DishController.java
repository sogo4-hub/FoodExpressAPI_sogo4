package es.daw.foodexpressapi_sogo4.controller;

import es.daw.foodexpressapi_sogo4.dto.DishDTO;
import es.daw.foodexpressapi_sogo4.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


import java.util.List;
@RestController
@RequestMapping("/api/dish")
@AllArgsConstructor
public class DishController {

    private final DishService dishService;
    @GetMapping
    public ResponseEntity<Page<DishDTO>> findAll(
            @PageableDefault(size = 5, page = 0) Pageable pageable) {

        return ResponseEntity.ok(dishService.getAllDishes(pageable));
    }

}
