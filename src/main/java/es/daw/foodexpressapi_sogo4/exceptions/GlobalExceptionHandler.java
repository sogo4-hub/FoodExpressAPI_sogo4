package es.daw.foodexpressapi_sogo4.exceptions;

import es.daw.foodexpressapi_sogo4.exceptions.InvalidStatusException;
import es.daw.foodexpressapi_sogo4.exceptions.RestaurantNotFoundException;
import es.daw.foodexpressapi_sogo4.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de Status inválido -> HTTP 400 (Bad Request)
    @ExceptionHandler(InvalidStatusException.class)
    public ResponseEntity<String> handleInvalidStatus(InvalidStatusException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    // Manejo de Usuario no encontrado -> HTTP 404 (Not Found)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    // Manejo de Restaurante no encontrado -> HTTP 404 (Not Found)
    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<String> handleRestaurantNotFound(RestaurantNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
