package es.daw.foodexpressapi_sogo4.enumerado;

public enum OrderStatus {
    // Deben coincidir con lo que hay en data.sql
    PENDIENTE,     // (Si usas un valor por defecto al crear)
    PREPARANDO,    // Coincide con tu data.sql
    ENTREGADO,     // Coincide con tu data.sql
    EN_CAMINO,
    CANCELADO;
}