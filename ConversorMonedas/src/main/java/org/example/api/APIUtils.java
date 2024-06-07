package org.example.api;

import com.google.gson.Gson;
import org.example.models.Currency;

/**
 * Esta clase contiene métodos de utilidad para trabajar con la API.
 * Proporciona métodos para obtener información específica de la API.
 */
public class APIUtils {
    /**
     * Obtiene la información de una moneda desde la API.
     *
     * @param currencyKey La clave de la moneda que se desea consultar.
     * @return Un objeto Moneda con la información obtenida de la API.
     */
    public Currency getCurrencyFromAPI(String currencyKey) {
        // Construcción de la URL de la API utilizando la configuración base y la clave de la moneda
        String apiUrl = APIConfig.BASE_URL + currencyKey;
        // Envío de la solicitud GET a la API y obtención de la respuesta
        APIResponse response = APIClient.sendGETRequest(apiUrl);
        // Obtención del cuerpo de la respuesta en formato JSON
        String responseBody = response.getResponseBody();
        // Conversión del JSON a un objeto Currency utilizando Gson
        return new Gson().fromJson(responseBody, Currency.class);
    }
}

