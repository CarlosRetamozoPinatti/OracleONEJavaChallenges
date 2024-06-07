package org.example.api;

import java.net.http.HttpResponse;
/**
 * Esta clase encapsula la respuesta de la API.
 * Proporciona métodos para acceder al código de estado y al cuerpo de la respuesta.
 */
public class APIResponse {
    private final HttpResponse<String> response;

    public APIResponse(HttpResponse<String> response) {
        this.response = response;
    }
    /**
     * Obtiene el código de estado de la respuesta HTTP.
     *
     * @return El código de estado de la respuesta.
     */
    public int getStatusCode() {
        return response.statusCode();
    }
    /**
     * Obtiene el cuerpo de la respuesta HTTP como una cadena.
     *
     * @return El cuerpo de la respuesta en formato de cadena.
     */
    public String getResponseBody() {
        return response.body();
    }
}

