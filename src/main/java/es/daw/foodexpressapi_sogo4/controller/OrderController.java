package es.daw.foodexpressapi_sogo4.controller;

import es.daw.foodexpressapi_sogo4.dto.OrderResponseDTO;
import es.daw.foodexpressapi_sogo4.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getOrders(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long restaurantId) {

        return ResponseEntity.ok(orderService.searchOrders(status, userId, restaurantId));
    }
}