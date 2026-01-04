package es.daw.foodexpressapi_sogo4.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
